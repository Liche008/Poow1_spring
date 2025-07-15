package br.csi.projetoacademia.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.persistence.Table;

@Entity
@Table(name ="fichas")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Ficha {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_ficha;
    private String tipo;
    private String objetivo;
    private int id_usuario;
}
