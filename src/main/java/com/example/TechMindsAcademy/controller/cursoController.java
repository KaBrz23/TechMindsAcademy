package com.example.TechMindsAcademy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import static org.springframework.http.HttpStatus.CREATED;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.TechMindsAcademy.model.Curso;
import com.example.TechMindsAcademy.repository.CursoRepository;

import jakarta.validation.Valid;

@RestController
@RequestMapping("curso")
public class cursoController {
    @Autowired
    CursoRepository repository;

    @GetMapping
    public Page<Curso> index(
        @RequestParam(required = false) String categoria,
        @PageableDefault(size = 5, sort = "data", direction = Direction.DESC  ) Pageable pageable

    ){
        if (categoria != null){
            return repository.findByCategoriaNome(categoria, pageable);
        }

        return repository.findAll(pageable);
    }

    @PostMapping
    @ResponseStatus(CREATED)
    public Curso create(@RequestBody @Valid Curso curso){
        return repository.save(curso);
    }
}
