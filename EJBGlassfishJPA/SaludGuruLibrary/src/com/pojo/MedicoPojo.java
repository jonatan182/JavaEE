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
public class MedicoPojo implements Serializable {

    private int idmedico;
    private Integer identificacionmedico;
    private String nombremedico;
    private String apellidomedico;
    private int edadmedico;

    public MedicoPojo() {
    }

    public MedicoPojo(int identificacionmedico, String nombremedico) {
        this.identificacionmedico = identificacionmedico;
        this.nombremedico = nombremedico;

    }

    /**
     * @return the idmedico
     */
    public int getIdmedico() {
        return idmedico;
    }

    /**
     * @param idmedico the idmedico to set
     */
    public void setIdmedico(int idmedico) {
        this.idmedico = idmedico;
    }

    /**
     * @return the identificacionmedico
     */
    public Integer getIdentificacionmedico() {
        return identificacionmedico;
    }

    /**
     * @param identificacionmedico the identificacionmedico to set
     */
    public void setIdentificacionmedico(Integer identificacionmedico) {
        this.identificacionmedico = identificacionmedico;
    }

    /**
     * @return the nombremedico
     */
    public String getNombremedico() {
        return nombremedico;
    }

    /**
     * @param nombremedico the nombremedico to set
     */
    public void setNombremedico(String nombremedico) {
        this.nombremedico = nombremedico;
    }

    /**
     * @return the apellidomedico
     */
    public String getApellidomedico() {
        return apellidomedico;
    }

    /**
     * @param apellidomedico the apellidomedico to set
     */
    public void setApellidomedico(String apellidomedico) {
        this.apellidomedico = apellidomedico;
    }

    /**
     * @return the edadmedico
     */
    public int getEdadmedico() {
        return edadmedico;
    }

    /**
     * @param edadmedico the edadmedico to set
     */
    public void setEdadmedico(int edadmedico) {
        this.edadmedico = edadmedico;
    }

    @Override
    public String toString() {
        return nombremedico;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj != null) {
            String nombre2 = this.getNombremedico();
            String nombre = ((MedicoPojo) obj).getNombremedico();

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
