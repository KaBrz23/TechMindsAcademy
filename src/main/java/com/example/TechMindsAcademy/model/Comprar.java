package com.example.TechMindsAcademy.model;

import java.util.Random;

public record Comprar(Long id_compra, Long id_usuario, double preco){
    public Comprar(Long id_compra, Long id_usuario, double preco){
        var key = (id_compra == null) ? Math.abs(new Random().nextLong()) : id_compra;
        this.id_compra = key;
        this.id_usuario = id_usuario;
        this.preco = preco;
    }
}

