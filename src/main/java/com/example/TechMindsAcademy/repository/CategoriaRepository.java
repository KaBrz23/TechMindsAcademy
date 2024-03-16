package com.example.TechMindsAcademy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.TechMindsAcademy.model.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Long>{
    
}
