package br.com.fiap.fintech.service;

import br.com.fiap.fintech.model.Carteira;
import br.com.fiap.fintech.repository.CarteiraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CarteiraService {

    @Autowired
    private CarteiraRepository carteiraRepository;

    public Carteira salvar(Carteira carteira) {
        return carteiraRepository.save(carteira);
    }

    public Carteira buscarPorId(Long id) {
        Optional<Carteira> carteira = carteiraRepository.findById(id);

        if (carteira.isPresent()) {
            return carteira.get();
        }else {
            throw new RuntimeException("Carteira não encontrada!");
        }
    }

    public List<Carteira> buscarTodos() {
        return carteiraRepository.findAll();
    }

    public void excluir(Long id) {
        Optional<Carteira> carteira = carteiraRepository.findById(id);
        if (carteira.isPresent()) {
            carteiraRepository.deleteById(id);
        }else {
            throw new RuntimeException("Carteira não encontrada!");
        }
    }

    public Carteira atualizar(Long id, Carteira carteira) {
        Optional<Carteira> carteiraAtual = carteiraRepository.findById(id);
        if (carteiraAtual.isPresent()) {
            return carteiraRepository.save(carteira);
        }else {
            throw new RuntimeException("Carteira não encontrada!");
        }
    }

}
