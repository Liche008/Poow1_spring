package br.csi.projetoacademia.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name ="exercicios")
public class Exercicio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idExercicio;
    private String nomeExercicio;
    private String grupoMuscularExercicio;
    private String descricaoExercicio;

    // Construtor padrão (obrigatório para o JPA)
    public Exercicio() {}

    // Construtor com parâmetros (opcional)
    public Exercicio(Integer idExercicio, String nomeExercicio, String grupoMuscularExercicio, String descricaoExercicio) {
        this.idExercicio = idExercicio;
        this.nomeExercicio = nomeExercicio;
        this.grupoMuscularExercicio = grupoMuscularExercicio;
        this.descricaoExercicio = descricaoExercicio;
    }

    // Getters e Setters
    public Integer getIdExercicio() {
        return idExercicio;
    }

    public void setIdExercicio(Integer idExercicio) {
        this.idExercicio = idExercicio;
    }

    public String getNomeExercicio() {
        return nomeExercicio;
    }

    public void setNomeExercicio(String nomeExercicio) {
        this.nomeExercicio = nomeExercicio;
    }

    public String getGrupoMuscularExercicio() {
        return grupoMuscularExercicio;
    }

    public void setGrupoMuscularExercicio(String grupoMuscularExercicio) {
        this.grupoMuscularExercicio = grupoMuscularExercicio;
    }

    public String getDescricaoExercicio() {
        return descricaoExercicio;
    }

    public void setDescricaoExercicio(String descricaoExercicio) {
        this.descricaoExercicio = descricaoExercicio;
    }
}
