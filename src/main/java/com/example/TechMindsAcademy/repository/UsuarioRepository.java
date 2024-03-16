package com.example.TechMindsAcademy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.TechMindsAcademy.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{
    
}
