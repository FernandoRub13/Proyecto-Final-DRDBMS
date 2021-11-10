package com.drdbms.proyectofinal.services.db;

import java.util.List;
import java.util.Optional;

import com.drdbms.proyectofinal.model.Persona;
import com.drdbms.proyectofinal.repository.PersonasRepository;
import com.drdbms.proyectofinal.services.IPersonasService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@Primary
public class PersonaService implements IPersonasService {
  
  @Autowired
  private PersonasRepository personaRepository;

  @Override
  public void guardar(Persona persona) {
    personaRepository.save(persona);
    
  }

  @Override
  public List<Persona> buscarTodos() {
    return personaRepository.findAll();
  }

  @Override
  public Persona buscarPorId(Integer id) {
    Optional<Persona> persona = personaRepository.findById(id);
    if (persona.isPresent()) {
      return persona.get();  
    }
    return null;
  }

  @Override
  public void eliminar(Integer id) {
    personaRepository.deleteById(id);
  }

  @Override
  public Page<Persona> buscarPorPagina(Pageable page) {
    return personaRepository.findAll(page);
  }


  

}
