package com.example.TechMindsAcademy.config;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.example.TechMindsAcademy.model.Categoria;
import com.example.TechMindsAcademy.model.Curso;
import com.example.TechMindsAcademy.repository.CategoriaRepository;
import com.example.TechMindsAcademy.repository.CursoRepository;

@Configuration
public class DatabaseSeeder implements CommandLineRunner{
    @Autowired
    CategoriaRepository categoriaRepository;

    @Autowired
    CursoRepository cursoRepository;

    @Override
    public void run(String... args) throws Exception {
        categoriaRepository.saveAll(
            List.of(
                Categoria.builder().id_categoria(1L).nome("Cloud").icone("apple").build(),
                Categoria.builder().id_categoria(2L).nome("Data").icone("book").build(),
                Categoria.builder().id_categoria(3L).nome("Dev").icone("bus").build()
            )
        );

        cursoRepository.saveAll(
            List.of(
                Curso.builder()
                    .id_curso(1L)
                    .curso("Cloud")
                    .descricao("Curso de AWS")
                    .preco(27.99)
                    .duracao("10 horas")
                    .instrutor("Kauê Braz")
                    .categoria(categoriaRepository.findById(1L).get())
                    .build()
            )
        );

    }
}

