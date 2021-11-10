package com.drdbms.proyectofinal.services.db;

import java.util.List;
import java.util.Optional;

import com.drdbms.proyectofinal.model.Paciente;
import com.drdbms.proyectofinal.repository.PacientesRepository;
import com.drdbms.proyectofinal.services.IPacientesService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@Primary
public class PacientesService implements IPacientesService {

  @Autowired
  private PacientesRepository pacientesRepository;

  @Override
  public void guardar(Paciente paciente) {
    pacientesRepository.save(paciente);
    
  }

  @Override
  public List<Paciente> buscarTodos() {
    return pacientesRepository.findAll();
  }

  @Override
  public Paciente buscarPorId(Integer id) {
    Optional<Paciente> paciente = pacientesRepository.findById(id);
    if (paciente.isPresent()) {
      return paciente.get();
    }
    return null;
  }

  @Override
  public void eliminar(Integer id) {
    pacientesRepository.deleteById(id);
  }

  @Override
  public Page<Paciente> buscarPorPagina(Pageable page) {
    return pacientesRepository.findAll(page);
  }
  
}
