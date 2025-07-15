package br.csi.projetoacademia.controller;

import br.csi.projetoacademia.model.Ficha;
import br.csi.projetoacademia.service.FichaService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("/fichas")
public class FichaController {

    @Autowired
    private FichaService fichaService;

    @GetMapping
    public String listarFichas(Model model, HttpSession session) {
        if (session.getAttribute("usuarioLogado") == null) {
            return "redirect:/login";
        }
        model.addAttribute("fichas", fichaService.listarTodas());
        return "fichas/lista";
    }

    @GetMapping("/nova")
    public String novaFicha(Model model, HttpSession session) {
        if (session.getAttribute("usuarioLogado") == null) {
            return "redirect:/login";
        }
        model.addAttribute("ficha", new Ficha());
        return "fichas/form";
    }

    @PostMapping
    public String salvarFicha(@ModelAttribute Ficha ficha, HttpSession session) {
        if (session.getAttribute("usuarioLogado") == null) {
            return "redirect:/login";
        }
        fichaService.salvar(ficha);
        return "redirect:/fichas";
    }

    @GetMapping("/editar/{id}")
    public String editarFicha(@PathVariable Integer id, Model model, HttpSession session) {
        if (session.getAttribute("usuarioLogado") == null) {
            return "redirect:/login";
        }
        Optional<Ficha> fichaOpt = fichaService.buscarPorId(id);
        if (fichaOpt.isEmpty()) {
            return "redirect:/fichas";
        }
        model.addAttribute("ficha", fichaOpt.get());
        return "fichas/form";
    }

    @PostMapping("/editar/{id}")
    public String atualizarFicha(@PathVariable Integer id, @ModelAttribute Ficha ficha, HttpSession session) {
        if (session.getAttribute("usuarioLogado") == null) {
            return "redirect:/login";
        }
        ficha.setId_ficha(id);
        fichaService.salvar(ficha);
        return "redirect:/fichas";
    }

    @GetMapping("/deletar/{id}")
    public String deletarFicha(@PathVariable Integer id, HttpSession session) {
        if (session.getAttribute("usuarioLogado") == null) {
            return "redirect:/login";
        }
        fichaService.deletarPorId(id);
        return "redirect:/fichas";
    }
}
