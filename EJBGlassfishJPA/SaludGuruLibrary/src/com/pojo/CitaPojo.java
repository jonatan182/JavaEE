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
public class CitaPojo implements Serializable{
    private Integer idcita;
    private String fecha;
    private String hora;
    private MedicoPojo medico = new MedicoPojo();
    private PacientePojo paciente = new PacientePojo();

    public PacientePojo getPaciente() {
        return paciente;
    }

    public void setPaciente(PacientePojo paciente) {
        this.paciente = paciente;
    }

    /**
     * @return the idcita
     */
    public Integer getIdcita() {
        return idcita;
    }

    /**
     * @param idcita the idcita to set
     */
    public void setIdcita(Integer idcita) {
        this.idcita = idcita;
    }

    /**
     * @return the fecha
     */
    public String getFecha() {
        return fecha;
    }

    /**
     * @param fecha the fecha to set
     */
    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    /**
     * @return the hora
     */
    public String getHora() {
        return hora;
    }

    /**
     * @param hora the hora to set
     */
    public void setHora(String hora) {
        this.hora = hora;
    }


    /**
     * @return the medico
     */
    public MedicoPojo getMedico() {
        return medico;
    }

    /**
     * @param medico the medico to set
     */
    public void setMedico(MedicoPojo medico) {
        this.medico = medico;
    }
}
