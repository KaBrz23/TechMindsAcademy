package com.example.TechMindsAcademy.model;

import java.util.Random;

public record Curso(Long id_categoria, Long id_curso, String curso, String descricao, double preco, String duracao, String instrutor){
    public Curso(Long id_categoria, Long id_curso, String curso, String descricao, double preco, String duracao, String instrutor){
        var key = (id_curso == null) ? Math.abs(new Random().nextLong()) : id_curso;
        this.id_curso = key;
        this.curso = curso;
        this.descricao = descricao;
        this.preco = preco;
        this.duracao = duracao;
        this.instrutor = instrutor;
        this.id_categoria = id_categoria;
    }
}
