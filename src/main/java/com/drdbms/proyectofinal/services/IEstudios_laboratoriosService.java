package com.drdbms.proyectofinal.services;

import java.util.List;

import com.drdbms.proyectofinal.model.Estudios_laboratorio;
import com.drdbms.proyectofinal.model.Paciente;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IEstudios_laboratoriosService {
  void guardar(Estudios_laboratorio estudios_laboratorio);
  List<Estudios_laboratorio> buscarTodos();
  Estudios_laboratorio buscarPorId(Integer id);
  void eliminar(Integer id);
  Page<Estudios_laboratorio> buscarPorPagina(Pageable page);
  Integer contarEstudiosLaboratio(Integer id);
}
