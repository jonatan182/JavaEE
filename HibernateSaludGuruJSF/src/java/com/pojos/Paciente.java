package com.pojos;
// Generated 05-abr-2015 14:44:06 by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;

/**
 * Paciente generated by hbm2java
 */
public class Paciente  implements java.io.Serializable {


     private int idPaciente;
     private String nombrePaciente;
     private Integer edadPaciente;
     private String seguro;
     private Set citases = new HashSet(0);

    public Paciente() {
    }

	
    public Paciente(int idPaciente) {
        this.idPaciente = idPaciente;
    }
    public Paciente(int idPaciente, String nombrePaciente, Integer edadPaciente, String seguro, Set citases) {
       this.idPaciente = idPaciente;
       this.nombrePaciente = nombrePaciente;
       this.edadPaciente = edadPaciente;
       this.seguro = seguro;
       this.citases = citases;
    }
   
    public int getIdPaciente() {
        return this.idPaciente;
    }
    
    public void setIdPaciente(int idPaciente) {
        this.idPaciente = idPaciente;
    }
    public String getNombrePaciente() {
        return this.nombrePaciente;
    }
    
    public void setNombrePaciente(String nombrePaciente) {
        this.nombrePaciente = nombrePaciente;
    }
    public Integer getEdadPaciente() {
        return this.edadPaciente;
    }
    
    public void setEdadPaciente(Integer edadPaciente) {
        this.edadPaciente = edadPaciente;
    }
    public String getSeguro() {
        return this.seguro;
    }
    
    public void setSeguro(String seguro) {
        this.seguro = seguro;
    }
    public Set getCitases() {
        return this.citases;
    }
    
    public void setCitases(Set citases) {
        this.citases = citases;
    }




}


