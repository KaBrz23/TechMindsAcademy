package com.example.TechMindsAcademy.repository;

import com.example.TechMindsAcademy.model.Curso;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CursoRepository extends JpaRepository<Curso, Long>{
    Page<Curso> findByCategoriaNome(String categoria, Pageable pageable);
    
}
