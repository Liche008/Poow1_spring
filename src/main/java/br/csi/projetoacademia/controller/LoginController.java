package br.csi.projetoacademia.controller;

import br.csi.projetoacademia.model.Usuario;
import br.csi.projetoacademia.service.UsuarioService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Optional;

@Controller
public class LoginController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping("/login")
    public String loginPage() {
        return "login";
    }

    @PostMapping("/login")
    public String processarLogin(HttpServletRequest request, Model model) {
        String email = request.getParameter("email");
        String senha = request.getParameter("senha");

        Optional<Usuario> usuarioOpt = usuarioService.listarTodos().stream()
                .filter(u -> u.getEmail_usuario().equals(email) && u.getSenha_usuario().equals(senha))
                .findFirst();

        if (usuarioOpt.isPresent()) {
            request.getSession().setAttribute("usuarioLogado", usuarioOpt.get());
            return "redirect:/usuarios";
        } else {
            model.addAttribute("erro", "E-mail ou senha inválidos");
            return "login";
        }
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/login";
    }
}
