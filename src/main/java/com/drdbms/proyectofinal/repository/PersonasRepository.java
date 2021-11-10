package com.drdbms.proyectofinal.repository;

import com.drdbms.proyectofinal.model.Persona;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonasRepository extends JpaRepository<Persona, Integer>{
  
}
