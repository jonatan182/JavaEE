package com.model.pojos;
// Generated 12-jun-2016 20:44:28 by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;

/**
 * Cliente generated by hbm2java
 */
public class Cliente  implements java.io.Serializable {


     private int rut;
     private Tipocliente tipocliente;
     private String nombres;
     private String apellidos;
     private Set reservacions = new HashSet(0);

    public Cliente() {
    }

	
    public Cliente(int rut) {
        this.rut = rut;
    }
    public Cliente(int rut, Tipocliente tipocliente, String nombres, String apellidos, Set reservacions) {
       this.rut = rut;
       this.tipocliente = tipocliente;
       this.nombres = nombres;
       this.apellidos = apellidos;
       this.reservacions = reservacions;
    }
   
    public int getRut() {
        return this.rut;
    }
    
    public void setRut(int rut) {
        this.rut = rut;
    }
    public Tipocliente getTipocliente() {
        return this.tipocliente;
    }
    
    public void setTipocliente(Tipocliente tipocliente) {
        this.tipocliente = tipocliente;
    }
    public String getNombres() {
        return this.nombres;
    }
    
    public void setNombres(String nombres) {
        this.nombres = nombres;
    }
    public String getApellidos() {
        return this.apellidos;
    }
    
    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }
    public Set getReservacions() {
        return this.reservacions;
    }
    
    public void setReservacions(Set reservacions) {
        this.reservacions = reservacions;
    }




}


