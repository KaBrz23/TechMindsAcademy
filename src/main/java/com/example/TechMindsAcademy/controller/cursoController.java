package com.example.TechMindsAcademy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.NO_CONTENT;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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

    @GetMapping
    public Page<Curso> index(
        // @RequestParam(required = false) String curso,
        @PageableDefault(size = 3) Pageable pageable

    ){
        // if (curso != null){
        //     return repository.findByCursoNome(curso, pageable);
        // }

        return repository.findAll(pageable);
    }
    // @GetMapping
    // public List<Curso> index() {
    //     return repository.findAll();
    // }

    @GetMapping("{id}")
    public ResponseEntity<Curso> listarCurso(@PathVariable Long id){

        return repository
                .findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("{id}")
    @ResponseStatus(NO_CONTENT)
    public void deletarJogo(@PathVariable Long id){
        verificarExistenciaCurso(id);
        repository.deleteById(id);
    }

    @PutMapping("{id}")
    public Curso atualizarCurso(@PathVariable Long id, @RequestBody Curso curso){
        
        verificarExistenciaCurso(id);
        curso.setId_curso(id);
        return repository.save(curso);
    }

    @PostMapping
    @ResponseStatus(CREATED)
    public Curso create(@RequestBody @Valid Curso curso){
        return repository.save(curso);
    }

    private void verificarExistenciaCurso(Long id) {
        repository
                .findById(id)
                .orElseThrow(() -> new ResponseStatusException(
                    HttpStatus.NOT_FOUND,
                    "Não existe curso com o id informado. Consulte lista em /curso."));
    }
}
