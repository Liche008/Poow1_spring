package br.csi.projetoacademia.service;

import br.csi.projetoacademia.model.Exercicio;
import br.csi.projetoacademia.repository.ExercicioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ExercicioService {

    @Autowired
    private ExercicioRepository exercicioRepository;

    public List<Exercicio> listarTodos() {
        return exercicioRepository.findAll();
    }

    public Optional<Exercicio> buscarPorId(Integer id) {
        return exercicioRepository.findById(id);
    }

    public Exercicio salvar(Exercicio exercicio) {
        return exercicioRepository.save(exercicio);
    }

    public void deletarPorId(Integer id) {
        exercicioRepository.deleteById(id);
    }
}
