package com.model.pojos;
// Generated 12-jun-2016 20:44:28 by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;

/**
 * Tipohabitacion generated by hbm2java
 */
public class Tipohabitacion  implements java.io.Serializable {


     private int idTipo;
     private String tipo;
     private Integer precio;
     private Set habitacions = new HashSet(0);
     private Set reservacions = new HashSet(0);

    public Tipohabitacion() {
    }

	
    public Tipohabitacion(int idTipo) {
        this.idTipo = idTipo;
    }
    public Tipohabitacion(int idTipo, String tipo, Integer precio, Set habitacions, Set reservacions) {
       this.idTipo = idTipo;
       this.tipo = tipo;
       this.precio = precio;
       this.habitacions = habitacions;
       this.reservacions = reservacions;
    }
   
    public int getIdTipo() {
        return this.idTipo;
    }
    
    public void setIdTipo(int idTipo) {
        this.idTipo = idTipo;
    }
    public String getTipo() {
        return this.tipo;
    }
    
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    public Integer getPrecio() {
        return this.precio;
    }
    
    public void setPrecio(Integer precio) {
        this.precio = precio;
    }
    public Set getHabitacions() {
        return this.habitacions;
    }
    
    public void setHabitacions(Set habitacions) {
        this.habitacions = habitacions;
    }
    public Set getReservacions() {
        return this.reservacions;
    }
    
    public void setReservacions(Set reservacions) {
        this.reservacions = reservacions;
    }




}

