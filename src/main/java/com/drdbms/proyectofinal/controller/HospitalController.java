package com.drdbms.proyectofinal.controller;

import java.util.List;

import com.drdbms.proyectofinal.model.Hospital;
import com.drdbms.proyectofinal.services.IHospitalesService;

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
@RequestMapping("/hospitales")
public class HospitalController {
  
  @Autowired
  private IHospitalesService hospitalesService;

  @GetMapping("/index")
  public String index(Model model, Pageable page) {
    Page<Hospital> hospitales = hospitalesService.buscarPorPagina(page);
    model.addAttribute("hospitales", hospitales);
    return "hospitales/index";
  }
  
  @GetMapping("/create")
  public String create(Hospital hospital) {
    return "hospitales/create";
  }
  
  @GetMapping("/edit/{id}")
  public String edit(@PathVariable(value = "id") Integer id, Model model) {
    Hospital hospital = hospitalesService.buscarPorId(id);
    model.addAttribute("hospital", hospital);
    return "hospitales/edit";
  }
  
  @PostMapping("/save")
  public String save(
    Hospital hospital,
    BindingResult result,
    RedirectAttributes attributes
    ) {
    if (result.hasErrors()) {
      for (ObjectError error : result.getAllErrors()) {
        System.out.println(error.getDefaultMessage());
      }
      return "hospitales/create";
    }
  
    hospitalesService.guardar(hospital);
    attributes.addFlashAttribute("msg", "Hospital guardado con éxito");
    return "redirect:/hospitales/index";
  }

  @PostMapping("/delete")
  public String delete(@RequestParam("id") Integer id, RedirectAttributes attributes) {
    

    try {
      hospitalesService.eliminar(id);
      attributes.addFlashAttribute("msg", "Hospital eliminado con éxito");

    } catch (Exception e) {
      String mensaje = "El hospital no se puede eliminar porque tiene médicos asociados, eliminelos primero por favor";
      attributes.addFlashAttribute("err", mensaje);
    }

    return "redirect:/hospitales/index";
  }

}
