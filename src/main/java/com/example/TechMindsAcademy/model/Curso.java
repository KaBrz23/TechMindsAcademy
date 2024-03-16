package com.example.TechMindsAcademy.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Curso{
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id_curso;
    private String curso;
    private String descricao;
    private double preco;
    private String duracao;
    private String instrutor;
    private Long id_categoria;
}
