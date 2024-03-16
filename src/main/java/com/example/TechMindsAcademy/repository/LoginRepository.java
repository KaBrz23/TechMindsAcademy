package com.example.TechMindsAcademy.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.TechMindsAcademy.model.Login;

public interface LoginRepository extends JpaRepository<Login, Long>{
    
}
