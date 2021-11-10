package com.drdbms.proyectofinal.controller;

import java.util.List;

import com.drdbms.proyectofinal.model.Hospital;
import com.drdbms.proyectofinal.model.Medico;
import com.drdbms.proyectofinal.services.IHospitalesService;
import com.drdbms.proyectofinal.services.IMedicosService;
import com.drdbms.proyectofinal.services.IPersonasService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/medicos")
public class MedicosController {
  
  @Autowired
  private IMedicosService medicosService;

  @Autowired
  private IHospitalesService hospitalesService;

  @Autowired IPersonasService personasService;

  @GetMapping("/index")
  public String index(Model model, Pageable page) {
    Page<Medico> medicos = medicosService.buscarPorPagina(page);
    model.addAttribute("medicos", medicos);
    return "medicos/index";
  }
  
  @GetMapping("/create")
  public String create(Model model, Medico medico) {
    List<Hospital> hospitales = hospitalesService.buscarTodos();
    model.addAttribute("hospitales", hospitales );
    return "medicos/create";
  }
  
  @GetMapping("/edit/{id}")
  public String edit(@PathVariable(value = "id") Integer id, Model model) {
    Medico medico = medicosService.buscarPorId(id);
    model.addAttribute("medico", medico);
    List<Hospital> hospitales = hospitalesService.buscarTodos();

    model.addAttribute("hospitales", hospitales );
    return "medicos/edit";
  }
  
  @PostMapping("/save")
  public String save(
    Medico medico,
    BindingResult result,
    RedirectAttributes attributes
    ) {
    if (result.hasErrors()) {
      for (ObjectError error : result.getAllErrors()) {
        System.out.println(error.getDefaultMessage());
      }
      return "medicos/create";
    }
  
    personasService.guardar(medico.getPersona());

    medicosService.guardar(medico);
    attributes.addFlashAttribute("msg", "Medico guardado con éxito");
    return "redirect:/medicos/index";
  }

  @PostMapping("/delete")
  public String delete(@RequestParam("id") Integer id, RedirectAttributes attributes) {
    Medico medico = medicosService.buscarPorId(id);
    int idPersona = medico.getPersona().getId();
    medicosService.eliminar(id);
    personasService.eliminar(idPersona);
    
    attributes.addFlashAttribute("msg", "Medico eliminado con éxito");
    return "redirect:/medicos/index";
  }

}
