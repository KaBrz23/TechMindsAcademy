package com.example.TechMindsAcademy.controller;

import org.springframework.web.bind.annotation.RestController;

import com.example.TechMindsAcademy.model.Comprar;
import com.example.TechMindsAcademy.model.Login;
import com.example.TechMindsAcademy.model.Usuario;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;


@RestController
@RequestMapping("/usuario")
public class usuarioController {
    Logger log = LoggerFactory.getLogger(getClass());
    List<Usuario> repositoryUsuario = new ArrayList<>();
    List<Comprar> repositoryComprar = new ArrayList<>();
    List<Login> repositoryLogin = new ArrayList<>();

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public Usuario create(@RequestBody Usuario usuario) {
        log.info("Cadastrando usuário: {}", usuario);
        repositoryUsuario.add(usuario);
        return usuario;
    }


    @PostMapping("/login")
    public Login login(@RequestBody Login login){
        log.info("logando usuário: {}", login);
        repositoryLogin.add(login);
        return login;
    }

    @PostMapping("/{id_usuario}/comprar")
    @ResponseStatus(code = HttpStatus.CREATED)
    public Comprar createCompra(@PathVariable("id_usuario") String idUsuario, @RequestBody Comprar comprar) {
        log.info("Cadastrando compra para usuário {} : {}", idUsuario, comprar);
        repositoryComprar.add(comprar);
        return comprar;
    }    

    
}
