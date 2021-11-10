package com.drdbms.proyectofinal.services;

import java.util.List;

import com.drdbms.proyectofinal.model.Paciente;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IPacientesService {
  void guardar(Paciente paciente);
  List<Paciente> buscarTodos();
  Paciente buscarPorId(Integer id);
  void eliminar(Integer id);
  Page<Paciente> buscarPorPagina(Pageable page);
}
