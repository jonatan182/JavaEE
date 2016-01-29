package com.pojos;
// Generated 05-abr-2015 14:44:06 by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;

/**
 * Medico generated by hbm2java
 */
public class Medico  implements java.io.Serializable {


     private int idMedico;
     private String nombreMedico;
     private Set citases = new HashSet(0);

    public Medico() {
    }

	
    public Medico(int idMedico) {
        this.idMedico = idMedico;
    }
    public Medico(int idMedico, String nombreMedico, Set citases) {
       this.idMedico = idMedico;
       this.nombreMedico = nombreMedico;
       this.citases = citases;
    }
   
    public int getIdMedico() {
        return this.idMedico;
    }
    
    public void setIdMedico(int idMedico) {
        this.idMedico = idMedico;
    }
    public String getNombreMedico() {
        return this.nombreMedico;
    }
    
    public void setNombreMedico(String nombreMedico) {
        this.nombreMedico = nombreMedico;
    }
    public Set getCitases() {
        return this.citases;
    }
    
    public void setCitases(Set citases) {
        this.citases = citases;
    }




}


