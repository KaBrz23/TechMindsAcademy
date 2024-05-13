package com.example.TechMindsAcademy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.NO_CONTENT;

import javax.swing.text.html.parser.Entity;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.PagedModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.example.TechMindsAcademy.model.Curso;
import com.example.TechMindsAcademy.repository.CursoRepository;

import jakarta.validation.Valid;

@RestController
@RequestMapping("curso")
public class cursoController {
    @Autowired
    CursoRepository repository;

    @Autowired
    PagedResourcesAssembler<Curso> pageAssembler;

    @GetMapping("{id}")
    public EntityModel<Curso> show(@PathVariable Long id){
        var curso = repository.findById(id).orElseThrow(
            () -> new IllegalArgumentException("curso não encontrado")
        );

        return curso.toEntityModel();
    }
    

    @GetMapping
    public PagedModel<EntityModel<Curso>> index(
        @PageableDefault(size = 3) Pageable pageable
    ){
        Page<Curso> page = null;
        if (page == null){
            page = repository.findAll(pageable);
        }

        return pageAssembler.toModel(page);
        
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Object> destroy(@PathVariable Long id){
        repository.findById(id).orElseThrow(
            () -> new IllegalArgumentException("curso não encontrado")
        );

        repository.deleteById(id);

        return ResponseEntity.noContent().build();

    }

    @PutMapping("{id}")
    public Curso atualizarCurso(@PathVariable Long id, @RequestBody Curso curso){
        
        verificarExistenciaCurso(id);
        curso.setId_curso(id);
        return repository.save(curso);
    }

    @PostMapping
    @ResponseStatus(CREATED)
    public ResponseEntity<Curso> create(@RequestBody @Valid Curso curso){
        repository.save(curso);
        return ResponseEntity
                    .created(curso.toEntityModel().getRequiredLink("self").toUri())
                    .body(curso);
    }

    private void verificarExistenciaCurso(Long id) {
        repository
                .findById(id)
                .orElseThrow(() -> new ResponseStatusException(
                    HttpStatus.NOT_FOUND,
                    "Não existe curso com o id informado. Consulte lista em /curso."));
    }
}
