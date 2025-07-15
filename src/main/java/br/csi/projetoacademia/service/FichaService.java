package br.csi.projetoacademia.service;

import br.csi.projetoacademia.model.Ficha;
import br.csi.projetoacademia.repository.FichaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FichaService {

    @Autowired
    private FichaRepository fichaRepository;

    public List<Ficha> listarTodas() {
        return fichaRepository.findAll();
    }

    public Optional<Ficha> buscarPorId(Integer id) {
        return fichaRepository.findById(id);
    }

    public Ficha salvar(Ficha ficha) {
        return fichaRepository.save(ficha);
    }

    public void deletarPorId(Integer id) {
        fichaRepository.deleteById(id);
    }
}
