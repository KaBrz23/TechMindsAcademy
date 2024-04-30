package com.example.TechMindsAcademy.repository;

import com.example.TechMindsAcademy.model.Curso;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CursoRepository extends JpaRepository<Curso, Long>{
    // @Query("SELECT c FROM Curso c WHERE c.curso LIKE %?1% ORDER BY c.curso ASC")
    
    // Page<Curso> findByCursoNome(String curso, Pageable pageable);

    // @Query("SELECT c FROM Curso C ORDER BY c.preco DESC")
    // Page<Curso> findByPreco(Pageable pageable);
    

}
