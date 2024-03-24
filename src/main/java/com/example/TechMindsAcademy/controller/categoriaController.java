package com.example.TechMindsAcademy.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.TechMindsAcademy.model.Categoria;
import com.example.TechMindsAcademy.repository.CategoriaRepository;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/categoria")
@Slf4j
public class categoriaController {
    @Autowired
    CategoriaRepository repository;

    /*
     * -- Inserindo dados na tabela Categoria
        INSERT INTO Categoria (id_categoria, nome, descricao) VALUES
        (1, 'Desenvolvimento', 'java'),
        (2, 'Cloud', 'cloud'),
        (3, 'Dados', 'database');

        -- Inserindo dados na tabela Curso
        INSERT INTO Curso (id_curso, id_categoria, nome, descricao, preco, duracao, instrutor) VALUES
        (1, 1, 'Documentação de API', 'Curso sobre como documentar API''s Restful', 14.99, '6 horas', 'Gabriel Fernandes'),
        (2, 1, 'Java Avançado', 'Aprofunde seus conhecimentos em desenvolvimento web', 199.99, '120 horas', 'Kauê Braz'); 
     */

    @GetMapping
    public List<Categoria> index() {
        return repository.findAll();
    }

    @GetMapping("{id_categoria}/curso")
    public ResponseEntity<Categoria> show(@PathVariable Long id_categoria){
        log.info("Buscando curso por id da categoria {}", id_categoria);

        return repository
                .findById(id_categoria)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
