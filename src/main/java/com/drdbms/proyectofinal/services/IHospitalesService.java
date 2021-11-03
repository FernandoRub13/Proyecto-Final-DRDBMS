package com.drdbms.proyectofinal.services;

import java.util.List;

import com.drdbms.proyectofinal.model.Hospital;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IHospitalesService {
  void guardar(Hospital hospital);
  List<Hospital> buscarTodos();
  Hospital buscarPorId(Integer id);
  void eliminar(Integer id);
  Page<Hospital> buscarPorPagina(Pageable page);
}
