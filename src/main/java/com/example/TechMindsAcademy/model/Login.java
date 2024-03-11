package com.example.TechMindsAcademy.model;

import java.util.Random;

public record Login(Long id, String email, String senha){
    public Login(Long id, String email, String senha){
        var key = (id == null) ? Math.abs(new Random().nextLong()) : id;
        this.id = key;
        this.email = email;
        this.senha = senha;
    }
}
