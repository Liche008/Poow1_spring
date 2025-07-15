package br.csi.projetoacademia.repository;

import br.csi.projetoacademia.model.Ficha;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FichaRepository extends JpaRepository<Ficha, Integer> {
}
