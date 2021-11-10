package com.drdbms.proyectofinal.services;

import java.util.List;

import com.drdbms.proyectofinal.model.Persona;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IPersonasService {
  void guardar(Persona persona);
  List<Persona> buscarTodos();
  Persona buscarPorId(Integer id);
  void eliminar(Integer id);
  Page<Persona> buscarPorPagina(Pageable page);
}
