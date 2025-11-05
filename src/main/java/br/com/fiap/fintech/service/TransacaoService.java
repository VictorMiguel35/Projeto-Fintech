package br.com.fiap.fintech.service;

import br.com.fiap.fintech.model.Carteira;
import br.com.fiap.fintech.model.Despesa;
import br.com.fiap.fintech.model.Receita;
import br.com.fiap.fintech.model.Transacao;
import br.com.fiap.fintech.repository.CarteiraRepository;
import br.com.fiap.fintech.repository.DespesaRepository;
import br.com.fiap.fintech.repository.ReceitaRepository;
import br.com.fiap.fintech.repository.TransacaoRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TransacaoService {

    @Autowired
    private ReceitaRepository receitaRepository;
    @Autowired
    private DespesaRepository despesaRepository;
    @Autowired
    private CarteiraRepository carteiraRepository;
    @Autowired
    private CarteiraService carteiraService;
    @Autowired
    private TransacaoRepository transacaoRepository;

    @Transactional
    public Receita salvarReceita(Receita receita) {
        Carteira carteira = carteiraService.buscarPorId(receita.getCarteira().getId());
        carteira.creditar(receita.getValorTransacao());

        carteiraRepository.save(carteira);
        return receitaRepository.save(receita);
    }

    @Transactional
    public Despesa salvarDespesa(Despesa despesa) {
        Carteira carteira = carteiraService.buscarPorId(despesa.getCarteira().getId());
        carteira.debitar(despesa.getValorTransacao());
        carteiraRepository.save(carteira);
        return despesaRepository.save(despesa);
    }

    public Transacao buscarPorId(Long id) {
        Optional<Transacao> transacao = transacaoRepository.findById(id);

        if (transacao.isPresent()) {
            return transacao.get();
        }else {
            throw new RuntimeException("Transação não encontrada!");
        }
    }

    public List<Transacao> buscarTodos() {
        return transacaoRepository.findAll();
    }

    @Transactional
    public void excluir(Long id) {
        Transacao transacao = buscarPorId(id);
        Carteira carteira = transacao.getCarteira();

        if (transacao instanceof Receita) {
            carteira.debitar(transacao.getValorTransacao());
        } else if (transacao instanceof Despesa) {
            carteira.creditar(transacao.getValorTransacao());
        }
        carteiraRepository.save(carteira);
        transacaoRepository.delete(transacao);
    }

    @Transactional
    public Transacao atualizarDescricao(Long id, String novaDescricao) {
        Transacao transacao = buscarPorId(id);
        transacao.setDescricaoTransacao(novaDescricao);
        return transacaoRepository.save(transacao);
    }
}
