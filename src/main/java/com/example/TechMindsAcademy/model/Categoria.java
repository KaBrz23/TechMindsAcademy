package com.example.TechMindsAcademy.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Categoria{
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id_categoria;
    @NotBlank(message = "Nome é obrigatória")
    @Size(min = 3, max= 255, message = "Nome deve ter pelo menos 3 caracteres")
    private String nome;
    @NotNull
    private String icone;
    
   
}
