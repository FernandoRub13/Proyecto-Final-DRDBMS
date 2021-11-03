package com.drdbms.proyectofinal.services.db;

import java.util.List;
import java.util.Optional;

import com.drdbms.proyectofinal.model.Estudios_laboratorio;
import com.drdbms.proyectofinal.repository.Estudios_laboratorioRepository;
import com.drdbms.proyectofinal.services.IEstudios_laboratoriosService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@Primary
public class Estudios_laboratoriosService implements IEstudios_laboratoriosService {

  @Autowired
  private Estudios_laboratorioRepository estudios_laboratoriosRepository;

  @Override
  public void guardar(Estudios_laboratorio estudios_laboratorio) {
    estudios_laboratoriosRepository.save(estudios_laboratorio);
    
  }

  @Override
  public List<Estudios_laboratorio> buscarTodos() {
    return estudios_laboratoriosRepository.findAll();
  }

  @Override
  public Estudios_laboratorio buscarPorId(Integer id) {
    Optional<Estudios_laboratorio> estudios_laboratorio = estudios_laboratoriosRepository.findById(id);
    if (estudios_laboratorio.isPresent()) {
      return estudios_laboratorio.get();
    }
    return null;
  }

  @Override
  public void eliminar(Integer id) {
    estudios_laboratoriosRepository.deleteById(id);
    
  }

  @Override
  public Page<Estudios_laboratorio> buscarPorPagina(Pageable page) {
    return estudios_laboratoriosRepository.findAll(page);
  }

}
