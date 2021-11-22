package com.drdbms.proyectofinal.controller;

import java.util.List;

import com.drdbms.proyectofinal.model.Estudios_laboratorio;
import com.drdbms.proyectofinal.model.Paciente;
import com.drdbms.proyectofinal.services.IEstudios_laboratoriosService;
import com.drdbms.proyectofinal.services.IPacientesService;

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
@RequestMapping("/estudios")
public class Estudios_laboratorioController {

  @Autowired IPacientesService pacientesService;

  @Autowired IEstudios_laboratoriosService estudios_laboratoriosService;

  @GetMapping("/index")
  public String index(Model model, Pageable page) {
    Page<Estudios_laboratorio> estudios = estudios_laboratoriosService.buscarPorPagina(page);
    model.addAttribute("estudios", estudios);
    return "estudios/index";
  }
  
  @GetMapping("/create")
  public String create(Model model, Estudios_laboratorio estudios_laboratorio) {
    List<Paciente> pacientes = pacientesService.buscarTodos();
    model.addAttribute("pacientes", pacientes );
    

    return "estudios/create";
  }
  
  @GetMapping("/edit/{id}")
  public String edit(@PathVariable(value = "id") Integer id, Model model) {
    List<Paciente> pacientes = pacientesService.buscarTodos();
    model.addAttribute("pacientes", pacientes );
    Estudios_laboratorio estudios_laboratorio = estudios_laboratoriosService.buscarPorId(id);
    model.addAttribute("estudio", estudios_laboratorio);
    model.addAttribute("paciente", estudios_laboratorio.getPaciente());
    return "estudios/edit";
  }
  
  @PostMapping("/save")
  public String save(
    Estudios_laboratorio estudios_laboratorio,
    BindingResult result,
    RedirectAttributes attributes
    ) {
    if (result.hasErrors()) {
      for (ObjectError error : result.getAllErrors()) {
        System.out.println(error.getDefaultMessage());
      }
      return "estudios/create";
    }
    estudios_laboratoriosService.guardar(estudios_laboratorio);
    attributes.addFlashAttribute("msg", "Estudio de laboratorio guardado con éxito");
    return "redirect:/estudios/index";
  }

  @PostMapping("/delete")
  public String delete(@RequestParam("id") Integer id, RedirectAttributes attributes) {
    try {
      estudios_laboratoriosService.eliminar(id);
      attributes.addFlashAttribute("msg", "Estudio de laboratorio eliminado con éxito");
    } catch (Exception e) {
      attributes.addFlashAttribute("err", "Estudio de laboratorio no pudo ser eliminado");
    } 
    
    return "redirect:/estudios/index";
  }
}
