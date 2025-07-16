package br.csi.projetoacademia.service;

import br.csi.projetoacademia.model.Usuario;
import br.csi.projetoacademia.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LoginService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public boolean validarLogin(String email, String senha) {
        Optional<Usuario> usuarioOpt = usuarioRepository.findByEmailUsuario(email);
        if (usuarioOpt.isPresent()) {
            Usuario usuario = usuarioOpt.get();
            return usuario.getSenhaUsuario().equals(senha);
        }
        return false;
    }

    public Optional<Usuario> autenticar(String email, String senha) {
        Optional<Usuario> usuarioOpt = usuarioRepository.findByEmailUsuario(email);
        if (usuarioOpt.isPresent() && usuarioOpt.get().getSenhaUsuario().equals(senha)) {
            return usuarioOpt;
        }
        return Optional.empty();
    }
}
