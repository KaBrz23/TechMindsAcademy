package com.example.TechMindsAcademy.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.TechMindsAcademy.model.Categoria;
import com.example.TechMindsAcademy.model.Curso;

@RestController
@RequestMapping("/categoria")
public class categoriaController {
    Logger log = LoggerFactory.getLogger(getClass());
    List<Categoria> repositoryCategoria = new ArrayList<>();
    List<Curso> repositoryCurso = new ArrayList<>();

    public categoriaController() {
        repositoryCategoria.add(new Categoria((long) 1, "Desenvolvimento", "java"));
        repositoryCategoria.add(new Categoria((long) 2, "Cloud", "cloud"));
        repositoryCategoria.add(new Categoria((long) 3, "Dados", "database"));
        repositoryCurso.add(new Curso((long) 1,(long) 1, "Documentação de API", "Curso sobre como documentar API's Restful", 14.99, "6 horas", "Gabriel Fernandes"));
        repositoryCurso.add(new Curso((long) 1,(long) 2, "Java Avançado", "Aprofunde seus conhecimentos em desenvolvimento web", 199.99, "120 horas", "Kauê Braz"));
    }

    @GetMapping
    public List<Categoria> index() {
        return repositoryCategoria;
    }

    @SuppressWarnings("rawtypes")
    @GetMapping("{id_categoria}/curso")
    public ResponseEntity show(@PathVariable Long id_categoria){
        log.info("Buscando curso por id da categoria {}", id_categoria);

        var cursosEncontrados = getCursosByCategoriaId(id_categoria);

        if(cursosEncontrados.isEmpty()){
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(cursosEncontrados);
    }

    private List<Curso> getCursosByCategoriaId(Long id) {
    List<Curso> cursosEncontrados = repositoryCurso.stream()
            .filter(c -> c.id_categoria().equals(id))
            .collect(Collectors.toList());
    return cursosEncontrados;
    }

}
