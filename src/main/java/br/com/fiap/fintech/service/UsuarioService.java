package br.com.fiap.fintech.service;

import br.com.fiap.fintech.model.Usuario;
import br.com.fiap.fintech.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public Usuario salvar(Usuario usuario) {
        return  usuarioRepository.save(usuario);
    }

    public Usuario buscarPorId(Long id) {
        Optional<Usuario> usuario = usuarioRepository.findById(id);

        if (usuario.isPresent()){
            return usuario.get();
        }else {
            throw new RuntimeException("Usuário não encontrado!");
        }
    }

    public List<Usuario> buscarTodos() {
        return usuarioRepository.findAll();
    }

    public void excluir(Long id) {
        Optional<Usuario> usuario = usuarioRepository.findById(id);
        if (usuario.isPresent()){
        usuarioRepository.deleteById(id);
        }else {
            throw new RuntimeException("Usuário não encontrado!");
        }
    }

    public Usuario atualizar(Long id, Usuario usuarioNovosDados) {
        Usuario usuarioExistente = buscarPorId(id); // Reutiliza seu método que já lança exceção
        usuarioExistente.setNomeUsuario(usuarioNovosDados.getNomeUsuario());
        usuarioExistente.setEmailUsuario(usuarioNovosDados.getEmailUsuario());
        return usuarioRepository.save(usuarioExistente);
    }


}
