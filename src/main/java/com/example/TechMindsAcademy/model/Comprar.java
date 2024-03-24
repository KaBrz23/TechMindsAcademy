package com.example.TechMindsAcademy.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Data;

@Data
@Entity
public class Comprar{
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id_compra;
    @NotNull
    private Long id_usuario;
    @Positive(message = "O valor deve ser positivo")
    private double preco;
}

