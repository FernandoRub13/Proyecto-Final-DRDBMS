package com.drdbms.proyectofinal.repository;

import com.drdbms.proyectofinal.model.Hospital;

import org.springframework.data.jpa.repository.JpaRepository;

public interface HospitalesRepository extends JpaRepository<Hospital, Integer> {

  
}
