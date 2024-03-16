package com.example.TechMindsAcademy.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Comprar{
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id_compra;
    private Long id_usuario;
    private double preco;
}

