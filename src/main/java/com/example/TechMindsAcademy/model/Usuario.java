package com.example.TechMindsAcademy.model;

import java.util.Random;

public record Usuario(Long id, String nome, String email, String senha) {
    public Usuario(Long id, String nome, String email, String senha){
        var key = (id == null) ? Math.abs(new Random().nextLong()) : id;
        this.id = key;
        this.nome = nome;
        this.email = email;
        this.senha = senha;
    }
}
