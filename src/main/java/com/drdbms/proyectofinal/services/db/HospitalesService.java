package com.drdbms.proyectofinal.services.db;

import java.util.List;
import java.util.Optional;

import com.drdbms.proyectofinal.model.Hospital;
import com.drdbms.proyectofinal.repository.HospitalesRepository;
import com.drdbms.proyectofinal.services.IHospitalesService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@Primary
public class HospitalesService implements IHospitalesService {

  @Autowired
  private HospitalesRepository hospitalesRepository;

  @Override
  public void guardar(Hospital hospital) {
    hospitalesRepository.save(hospital);    
  }

  @Override
  public List<Hospital> buscarTodos() {
    return hospitalesRepository.findAll();
  }

  @Override
  public Hospital buscarPorId(Integer id) {
    Optional<Hospital> hospital = hospitalesRepository.findById(id);
    if (hospital.isPresent()) {
      return hospital.get();
    }
    return null;
  }

  @Override
  public void eliminar(Integer id) {
    hospitalesRepository.deleteById(id);    
  }

  @Override
  public Page<Hospital> buscarPorPagina(Pageable page) {
    return hospitalesRepository.findAll(page);
  }
  
}
