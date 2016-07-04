package com.model.pojos;
// Generated 12-jun-2016 20:44:28 by Hibernate Tools 4.3.1



/**
 * Reservacion generated by hbm2java
 */
public class Reservacion  implements java.io.Serializable {


     private int idReservacion;
     private Cliente cliente;
     private Habitacion habitacion;
     private Tipohabitacion tipohabitacion;
     private String fechaComienzo;
     private Integer numeroDias;

    public Reservacion() {
    }

	
    public Reservacion(int idReservacion) {
        this.idReservacion = idReservacion;
    }
    public Reservacion(int idReservacion, Cliente cliente, Habitacion habitacion, Tipohabitacion tipohabitacion, String fechaComienzo, Integer numeroDias) {
       this.idReservacion = idReservacion;
       this.cliente = cliente;
       this.habitacion = habitacion;
       this.tipohabitacion = tipohabitacion;
       this.fechaComienzo = fechaComienzo;
       this.numeroDias = numeroDias;
    }
   
    public int getIdReservacion() {
        return this.idReservacion;
    }
    
    public void setIdReservacion(int idReservacion) {
        this.idReservacion = idReservacion;
    }
    public Cliente getCliente() {
        return this.cliente;
    }
    
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    public Habitacion getHabitacion() {
        return this.habitacion;
    }
    
    public void setHabitacion(Habitacion habitacion) {
        this.habitacion = habitacion;
    }
    public Tipohabitacion getTipohabitacion() {
        return this.tipohabitacion;
    }
    
    public void setTipohabitacion(Tipohabitacion tipohabitacion) {
        this.tipohabitacion = tipohabitacion;
    }
    public String getFechaComienzo() {
        return this.fechaComienzo;
    }
    
    public void setFechaComienzo(String fechaComienzo) {
        this.fechaComienzo = fechaComienzo;
    }
    public Integer getNumeroDias() {
        return this.numeroDias;
    }
    
    public void setNumeroDias(Integer numeroDias) {
        this.numeroDias = numeroDias;
    }




}

