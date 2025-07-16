package br.csi.projetoacademia.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name ="fichas")
public class Ficha {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idFicha;
    private String tipo;
    private String objetivo;
    private int idUsuario;

    // Construtor padrão (obrigatório para o JPA)
    public Ficha() {}

    // Construtor com parâmetros
    public Ficha(Integer idFicha, String tipo, String objetivo, int idUsuario) {
        this.idFicha = idFicha;
        this.tipo = tipo;
        this.objetivo = objetivo;
        this.idUsuario = idUsuario;
    }

    // Getters e Setters
    public Integer getIdFicha() {
        return idFicha;
    }

    public void setIdFicha(Integer idFicha) {
        this.idFicha = idFicha;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getObjetivo() {
        return objetivo;
    }

    public void setObjetivo(String objetivo) {
        this.objetivo = objetivo;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }
}
