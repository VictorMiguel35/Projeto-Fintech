package br.com.fiap.fintech.service;

import br.com.fiap.fintech.model.Transacao;
import br.com.fiap.fintech.repository.TransacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TransacaoService {

    @Autowired
    private TransacaoRepository transacaoRepository;

    public Transacao salvar(Transacao transacao) {
        return transacaoRepository.save(transacao);
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

    public void excluir(Long id) {
        Optional<Transacao> transacao = transacaoRepository.findById(id);
        if (transacao.isPresent()) {
            transacaoRepository.deleteById(id);
        }else {
            throw new RuntimeException("Transação não encontrada!");
        }
    }

    public Transacao atualizar(Long id, Transacao transacao) {
        Optional<Transacao> transacaoAtual = transacaoRepository.findById(id);
        if (transacaoAtual.isPresent()) {
            return transacaoRepository.save(transacao);
        }else {
            throw new RuntimeException("Transação não encontrada!");
        }
    }
}
