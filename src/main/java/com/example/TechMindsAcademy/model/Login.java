package com.example.TechMindsAcademy.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Login{
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id_login;
    private String email;
    private String senha;
}

