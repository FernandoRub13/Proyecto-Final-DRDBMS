package com.drdbms.proyectofinal.services;

import java.util.List;

import com.drdbms.proyectofinal.model.Medico;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IMedicosService {
  void guardar(Medico medico);
  List<Medico> buscarTodos();
  Medico buscarPorId(Integer id);
  void eliminar(Integer id);
  Page<Medico> buscarPorPagina(Pageable page);
}
