package br.csi.projetoacademia.controller;

import br.csi.projetoacademia.model.Usuario;
import br.csi.projetoacademia.service.UsuarioService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping
    public String listarUsuarios(Model model) {
        model.addAttribute("usuarios", usuarioService.listarTodos());
        return "usuarios/lista";
    }

    @GetMapping("/novo")
    public String novoUsuario(Model model, HttpSession session) {
        if (session.getAttribute("usuarioLogado") == null) {
            return "redirect:/login";
        }
        model.addAttribute("usuario", new Usuario());
        return "usuarios/form";
    }

    @PostMapping
    public String salvarUsuario(@ModelAttribute Usuario usuario, HttpSession session) {
        if (session.getAttribute("usuarioLogado") == null) {
            return "redirect:/login";
        }
        usuarioService.salvar(usuario);
        return "redirect:/usuarios";
    }

    @GetMapping("/editar/{id}")
    public String editarUsuario(@PathVariable Integer id, Model model, HttpSession session) {
        if (session.getAttribute("usuarioLogado") == null) {
            return "redirect:/login";
        }
        Optional<Usuario> usuarioOpt = usuarioService.buscarPorId(id);
        if (usuarioOpt.isEmpty()) {
            return "redirect:/usuarios";
        }
        model.addAttribute("usuario", usuarioOpt.get());
        return "usuarios/form";
    }

    @PostMapping("/editar/{id}")
    public String atualizarUsuario(@PathVariable Integer id, @ModelAttribute Usuario usuario, HttpSession session) {
        if (session.getAttribute("usuarioLogado") == null) {
            return "redirect:/login";
        }
        usuario.setIdUsuario(id);
        usuarioService.salvar(usuario);
        return "redirect:/usuarios";
    }

    @GetMapping("/deletar/{id}")
    public String deletarUsuario(@PathVariable Integer id, HttpSession session) {
        if (session.getAttribute("usuarioLogado") == null) {
            return "redirect:/login";
        }
        usuarioService.deletarPorId(id);
        return "redirect:/usuarios";
    }
}
