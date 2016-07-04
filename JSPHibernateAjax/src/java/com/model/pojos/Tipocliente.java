package com.model.pojos;
// Generated 12-jun-2016 20:44:28 by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;

/**
 * Tipocliente generated by hbm2java
 */
public class Tipocliente  implements java.io.Serializable {


     private int idTipoCliente;
     private String tipoCliente;
     private Integer descuento;
     private Set clientes = new HashSet(0);

    public Tipocliente() {
    }

	
    public Tipocliente(int idTipoCliente) {
        this.idTipoCliente = idTipoCliente;
    }
    public Tipocliente(int idTipoCliente, String tipoCliente, Integer descuento, Set clientes) {
       this.idTipoCliente = idTipoCliente;
       this.tipoCliente = tipoCliente;
       this.descuento = descuento;
       this.clientes = clientes;
    }
   
    public int getIdTipoCliente() {
        return this.idTipoCliente;
    }
    
    public void setIdTipoCliente(int idTipoCliente) {
        this.idTipoCliente = idTipoCliente;
    }
    public String getTipoCliente() {
        return this.tipoCliente;
    }
    
    public void setTipoCliente(String tipoCliente) {
        this.tipoCliente = tipoCliente;
    }
    public Integer getDescuento() {
        return this.descuento;
    }
    
    public void setDescuento(Integer descuento) {
        this.descuento = descuento;
    }
    public Set getClientes() {
        return this.clientes;
    }
    
    public void setClientes(Set clientes) {
        this.clientes = clientes;
    }




}


