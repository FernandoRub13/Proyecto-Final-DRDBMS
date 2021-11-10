package com.drdbms.proyectofinal.services.db;

import java.util.List;
import java.util.Optional;

import com.drdbms.proyectofinal.model.Medico;
import com.drdbms.proyectofinal.repository.MedicosRepository;
import com.drdbms.proyectofinal.services.IMedicosService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@Primary
public class MedicosService implements IMedicosService {

  @Autowired
  private MedicosRepository medicosRepository;

  @Override
  public void guardar(Medico medico) {
    medicosRepository.save(medico);
    
  }

  @Override
  public List<Medico> buscarTodos() {
    return medicosRepository.findAll();
  }

  @Override
  public Medico buscarPorId(Integer id) {
    Optional<Medico> medico = medicosRepository.findById(id);
    if (medico.isPresent()) {
      return medico.get();    
    }
    return null;
  }

  @Override
  public void eliminar(Integer id) {
    medicosRepository.deleteById(id);    
  }

  @Override
  public Page<Medico> buscarPorPagina(Pageable page) {
    return medicosRepository.findAll(page);
  }
  
}
