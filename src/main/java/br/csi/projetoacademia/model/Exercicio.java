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
@Table(name ="exercicios")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Exercicio{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_exercicio;
    private String nome_exercicio;
    private String grupomuscular_exercicio;
    private String descricao_exercicio;
}
