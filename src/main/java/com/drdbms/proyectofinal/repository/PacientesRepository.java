package com.drdbms.proyectofinal.repository;

import com.drdbms.proyectofinal.model.Paciente;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PacientesRepository extends JpaRepository<Paciente, Integer> {

  
}
