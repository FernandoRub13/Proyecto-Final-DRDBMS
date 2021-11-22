package com.drdbms.proyectofinal.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "estudios_laboratorio")
public class Estudios_laboratorio {
  
  @Id
  @GeneratedValue
  private Integer id;
  private String tipo_estudio;
  private String fecha_estudio;

  @OneToOne
  @JoinColumn(name = "paciente_id")
  private Paciente paciente;

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getTipo_estudio() {
    return tipo_estudio;
  }

  public void setTipo_estudio(String tipo_estudio) {
    this.tipo_estudio = tipo_estudio;
  }

  public String getFecha_estudio() {
    return fecha_estudio;
  }

  public void setFecha_estudio(String fecha_estudio) {
    this.fecha_estudio = fecha_estudio;
  }

  public Paciente getPaciente() {
    return paciente;
  }

  public void setPaciente(Paciente paciente) {
    this.paciente = paciente;
  }

  @Override
  public String toString() {
    return "estudios_laboratorio [fecha_estudio=" + fecha_estudio + ", id=" + id + ", paciente=" + paciente
        + ", tipo_estudio=" + tipo_estudio + "]";
  }

  

  


}
