package com.drdbms.proyectofinal.repository;

import com.drdbms.proyectofinal.model.Estudios_laboratorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface Estudios_laboratorioRepository extends JpaRepository<Estudios_laboratorio, Integer>{

  @Query(value = "SELECT count(*)   FROM estudios_laboratorio WHERE paciente_id=:paciente", nativeQuery = true)
  Integer countEstudiosLaboratorio(@Param("paciente") long pacienteId);

  @Query(value = "DELETE FROM estudios_laboratorio WHERE paciente_id=:paciente", nativeQuery = true)
  void deleteByPacienteId(@Param("paciente") Integer pacienteId);



}
