package com.drdbms.proyectofinal.controller;

import com.drdbms.proyectofinal.model.Paciente;
import com.drdbms.proyectofinal.services.IEstudios_laboratoriosService;
import com.drdbms.proyectofinal.services.IPacientesService;
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
@RequestMapping("/pacientes")
public class PacientesController {
    
  @Autowired
  IPersonasService personasService;

  @Autowired
  IPacientesService pacientesService;

  @Autowired
  IEstudios_laboratoriosService estudios_laboratoriosService;

  @GetMapping("/index")
  public String index(Model model, Pageable page) {
    Page<Paciente> pacientes = pacientesService.buscarPorPagina(page);
    model.addAttribute("pacientes", pacientes);
    return "pacientes/index";
  }
  
  @GetMapping("/create")
  public String create(Model model, Paciente paciente) {
    return "pacientes/create";
  }
  
  @GetMapping("/edit/{id}")
  public String edit(@PathVariable(value = "id") Integer id, Model model) {
    Paciente paciente = pacientesService.buscarPorId(id);
    model.addAttribute("paciente", paciente);
    return "pacientes/edit";
  }
  
  @PostMapping("/save")
  public String save(
    Paciente paciente,
    BindingResult result,
    RedirectAttributes attributes
    ) {
    if (result.hasErrors()) {
      for (ObjectError error : result.getAllErrors()) {
        System.out.println(error.getDefaultMessage());
      }
      return "pacientes/create";
    }
  
    personasService.guardar(paciente.getPersona());

    pacientesService.guardar(paciente);
    attributes.addFlashAttribute("msg", "Paciente guardado con éxito");
    return "redirect:/pacientes/index";
  }

  @PostMapping("/delete")
  public String delete(@RequestParam("id") Integer id, RedirectAttributes attributes) {
    Paciente paciente = pacientesService.buscarPorId(id);
    int idPersona = paciente.getPersona().getId();
    // String mensaje = "Paciente eliminado con éxito";
    try {
      pacientesService.eliminar(id);
      personasService.eliminar(idPersona);
      attributes.addFlashAttribute("msg", "Paciente eliminado con éxito");

    } catch (Exception e) {
      String mensaje = "El paciente no se puede eliminar porque tiene estudios asociados, eliminelos primero por favor";
      attributes.addFlashAttribute("err", mensaje);
    }
    
    return "redirect:/pacientes/index";
  }
}
