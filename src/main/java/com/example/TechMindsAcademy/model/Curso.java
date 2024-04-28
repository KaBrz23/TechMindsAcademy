package com.example.TechMindsAcademy.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
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
public class Curso{
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id_curso;

    @NotBlank(message = "Nome do curso é obrigatório")
    @Size(min = 3, max = 255, message = "Nome do curso deve ter pelo menos 3 caracteres")
    private String curso;

    @NotBlank(message = "Descrição é obrigatória")
    @Size(min = 3, max = 255, message = "Descrição deve ter pelo menos 3 caracteres")
    private String descricao;

    @Positive(message = "O valor deve ser positivo")
    private double preco;

    @NotNull
    private String duracao;
    @NotNull
    private String instrutor;
    
    @ManyToOne
    private Categoria categoria;

    
}
