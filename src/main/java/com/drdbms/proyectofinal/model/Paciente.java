package com.drdbms.proyectofinal.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "pacientes")
public class Paciente {
  
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;
  private String edad;
  private Float peso;
  private Float talla;
  private String padecimiento;
  private Integer num_estudios;

  @OneToOne
  @JoinColumn(name = "persona_id")
  private Persona persona;

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getEdad() {
    return edad;
  }

  public void setEdad(String edad) {
    this.edad = edad;
  }

  public Float getPeso() {
    return peso;
  }

  public void setPeso(Float peso) {
    this.peso = peso;
  }

  public Float getTalla() {
    return talla;
  }

  public void setTalla(Float talla) {
    this.talla = talla;
  }

  public String getPadecimiento() {
    return padecimiento;
  }

  public void setPadecimiento(String padecimiento) {
    this.padecimiento = padecimiento;
  }

  public Integer getNum_estudios() {
    return num_estudios;
  }

  public void setNum_estudios(Integer num_estudios) {
    this.num_estudios = num_estudios;
  }

  public Persona getPersona() {
    return persona;
  }

  public void setPersona(Persona persona) {
    this.persona = persona;
  }

  @Override
  public String toString() {
    return "Paciente [edad=" + edad + ", id=" + id + ", num_estudios=" + num_estudios + ", padecimiento=" + padecimiento
        + ", persona=" + persona + ", peso=" + peso + ", talla=" + talla + "]";
  } 
  
  
}
