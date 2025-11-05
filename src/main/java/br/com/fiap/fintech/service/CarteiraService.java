package br.com.fiap.fintech.service;

import br.com.fiap.fintech.model.Carteira;
import br.com.fiap.fintech.model.Usuario;
import br.com.fiap.fintech.repository.CarteiraRepository;
import br.com.fiap.fintech.repository.UsuarioRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CarteiraService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private CarteiraRepository carteiraRepository;

    @Transactional
    public Carteira salvar(Carteira carteira) {
        // Garante que o usuário associado existe
        if (carteira.getUsuario() == null || carteira.getUsuario().getId() == null) {
            throw new RuntimeException("Usuário é obrigatório para criar uma carteira.");
        }
        Usuario usuario = usuarioRepository.findById(carteira.getUsuario().getId())
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado!"));

        carteira.setUsuario(usuario);
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


    public Carteira atualizar(Long id, Carteira carteiraNovosDados) {
        Carteira carteiraExistente = buscarPorId(id);
        carteiraExistente.setNomeCarteira(carteiraNovosDados.getNomeCarteira());
        return carteiraRepository.save(carteiraExistente);
    }

}
