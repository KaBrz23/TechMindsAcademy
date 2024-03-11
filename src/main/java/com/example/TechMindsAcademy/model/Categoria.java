package com.example.TechMindsAcademy.model;

import java.util.Random;

public record Categoria(Long id_categoria, String nome, String icone){
    public Categoria(Long id_categoria, String nome, String icone){
        var key = (id_categoria == null) ? Math.abs(new Random().nextLong()) : id_categoria;
        this.id_categoria = key;
        this.nome = nome;
        this.icone = icone;
    }
}
