package com.example.TechMindsAcademy.controller;

import java.util.List;
import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.NO_CONTENT;
import org.springframework.beans.factory.annotation.Autowired;
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

import com.example.TechMindsAcademy.model.Categoria;
import com.example.TechMindsAcademy.repository.CategoriaRepository;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("categoria")
@Slf4j
public class categoriaController {
    @Autowired
    CategoriaRepository repository;

    @GetMapping
    public List<Categoria> index() {
        return repository.findAll();
    }

    @PostMapping
    @ResponseStatus(CREATED)
    public Categoria create(@RequestBody @Valid Categoria categoria) { // binding
        log.info("cadastrando categoria {} ", categoria);
        return repository.save(categoria);
    }

    @GetMapping("{id_categoria}")
    public ResponseEntity<Categoria> show(@PathVariable Long id_categoria) {
        log.info("buscando categoria por id {}", id_categoria);

        return repository
                .findById(id_categoria)
                .map(ResponseEntity::ok) // reference method
                .orElse(ResponseEntity.notFound().build());

    }

    @DeleteMapping("{id_categoria}")
    @ResponseStatus(NO_CONTENT)
    public void destroy(@PathVariable Long id_categoria) {
        log.info("apagando categoria");

        verificarSeExisteCategoria(id_categoria);
        repository.deleteById(id_categoria);
    }

    @PutMapping("{id_categoria}")
    public Categoria update(@PathVariable Long id_categoria, @RequestBody Categoria categoria) {
        log.info("atualizando categoria com id {} para {}", id_categoria, categoria);

        verificarSeExisteCategoria(id_categoria);
        categoria.setId_categoria(id_categoria);
        return repository.save(categoria);
    }

    private void verificarSeExisteCategoria(Long id_categoria) {
        repository
                .findById(id_categoria)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND,
                        "Não existe categoria com o id informado. Consulte lista em /categoria"));
    }
}
