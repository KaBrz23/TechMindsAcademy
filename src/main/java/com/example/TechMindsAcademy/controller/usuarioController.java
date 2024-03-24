package com.example.TechMindsAcademy.controller;

import org.springframework.web.bind.annotation.RestController;
import com.example.TechMindsAcademy.model.Comprar;
import com.example.TechMindsAcademy.model.Login;
import com.example.TechMindsAcademy.model.Usuario;
import com.example.TechMindsAcademy.repository.ComprarRepository;
import com.example.TechMindsAcademy.repository.LoginRepository;
import com.example.TechMindsAcademy.repository.UsuarioRepository;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;


@RestController
@RequestMapping("/usuario")
@Slf4j
public class usuarioController {
    @Autowired
    UsuarioRepository repositoryUsuario;
    @Autowired
    LoginRepository repositoryLogin;
    @Autowired
    ComprarRepository repositoryComprar;

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public Usuario create(@RequestBody @Valid Usuario usuario) {
        log.info("Cadastrando usuário: {}", usuario);
        repositoryUsuario.save(usuario);
        return usuario;
    }

    @PostMapping("/login")
    public Login login(@RequestBody @Valid Login login){
        log.info("logando usuário: {}", login);
        repositoryLogin.save(login);
        return login;
    }

    @PostMapping("{id_usuario}/comprar")
    @ResponseStatus(code = HttpStatus.CREATED)
    public Comprar createCompra(@PathVariable String id_usuario, @RequestBody @Valid Comprar comprar) {
        log.info("Cadastrando compra para usuário {} : {}", id_usuario, comprar);
        repositoryComprar.save(comprar);
        return comprar;
    } 
}
