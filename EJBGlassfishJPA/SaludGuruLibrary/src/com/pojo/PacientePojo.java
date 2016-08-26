/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pojo;

import java.io.Serializable;

/**
 *
 * @author jonatanjavier
 */
public class PacientePojo implements Serializable {

    private int idpaciente;
    private Integer identificacionpaciente;
    private String nombrepaciente;
    private String apellidopaciente;
    private int edad;

    public PacientePojo() {
    }

    public PacientePojo(int identificacionpaciente, String nombrepaciente) {
        this.identificacionpaciente = identificacionpaciente;
        this.nombrepaciente = nombrepaciente;
    }

    /**
     * @return the idpaciente
     */
    public int getIdpaciente() {
        return idpaciente;
    }

    /**
     * @param idpaciente the idpaciente to set
     */
    public void setIdpaciente(int idpaciente) {
        this.idpaciente = idpaciente;
    }

    /**
     * @return the identificacionpaciente
     */
    public Integer getIdentificacionpaciente() {
        return identificacionpaciente;
    }

    /**
     * @param identificacionpaciente the identificacionpaciente to set
     */
    public void setIdentificacionpaciente(Integer identificacionpaciente) {
        this.identificacionpaciente = identificacionpaciente;
    }

    /**
     * @return the nombrepaciente
     */
    public String getNombrepaciente() {
        return nombrepaciente;
    }

    /**
     * @param nombrepaciente the nombrepaciente to set
     */
    public void setNombrepaciente(String nombrepaciente) {
        this.nombrepaciente = nombrepaciente;
    }

    /**
     * @return the apellidopaciente
     */
    public String getApellidopaciente() {
        return apellidopaciente;
    }

    /**
     * @param apellidopaciente the apellidopaciente to set
     */
    public void setApellidopaciente(String apellidopaciente) {
        this.apellidopaciente = apellidopaciente;
    }

    /**
     * @return the edad
     */
    public int getEdad() {
        return edad;
    }

    /**
     * @param edad the edad to set
     */
    public void setEdad(int edad) {
        this.edad = edad;
    }

    @Override
    public String toString() {
        return nombrepaciente;
    }

    public boolean equals(Object obj) {
        if (obj != null) {
            String nombre2 = this.getNombrepaciente();
            String nombre = ((PacientePojo) obj).getNombrepaciente();

            if (nombre2.equals(nombre)) {
                System.out.println("Trueeee: " + nombre2 + "  " + nombre);
                return true;
            } else {
                System.out.println("Falseeee: " + nombre2 + "  " + nombre);
                return false;

            }
        } else {
            return false;
        }

    }
}
