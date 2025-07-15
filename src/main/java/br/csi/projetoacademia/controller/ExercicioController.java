package br.csi.projetoacademia.controller;

import br.csi.projetoacademia.model.Exercicio;
import br.csi.projetoacademia.service.ExercicioService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("/exercicios")
public class ExercicioController {

    @Autowired
    private ExercicioService exercicioService;

    @GetMapping
    public String listarExercicios(Model model, HttpSession session) {
        if (session.getAttribute("usuarioLogado") == null) {
            return "redirect:/login";
        }
        model.addAttribute("exercicios", exercicioService.listarTodos());
        return "exercicios/lista";
    }

    @GetMapping("/novo")
    public String novoExercicio(Model model, HttpSession session) {
        if (session.getAttribute("usuarioLogado") == null) {
            return "redirect:/login";
        }
        model.addAttribute("exercicio", new Exercicio());
        return "exercicios/form";
    }

    @PostMapping
    public String salvarExercicio(@ModelAttribute Exercicio exercicio, HttpSession session) {
        if (session.getAttribute("usuarioLogado") == null) {
            return "redirect:/login";
        }
        exercicioService.salvar(exercicio);
        return "redirect:/exercicios";
    }

    @GetMapping("/editar/{id}")
    public String editarExercicio(@PathVariable Integer id, Model model, HttpSession session) {
        if (session.getAttribute("usuarioLogado") == null) {
            return "redirect:/login";
        }
        Optional<Exercicio> exercicioOpt = exercicioService.buscarPorId(id);
        if (exercicioOpt.isEmpty()) {
            return "redirect:/exercicios";
        }
        model.addAttribute("exercicio", exercicioOpt.get());
        return "exercicios/form";
    }

    @PostMapping("/editar/{id}")
    public String atualizarExercicio(@PathVariable Integer id, @ModelAttribute Exercicio exercicio, HttpSession session) {
        if (session.getAttribute("usuarioLogado") == null) {
            return "redirect:/login";
        }
        exercicio.setId_exercicio(id);
        exercicioService.salvar(exercicio);
        return "redirect:/exercicios";
    }

    @GetMapping("/deletar/{id}")
    public String deletarExercicio(@PathVariable Integer id, HttpSession session) {
        if (session.getAttribute("usuarioLogado") == null) {
            return "redirect:/login";
        }
        exercicioService.deletarPorId(id);
        return "redirect:/exercicios";
    }
}
