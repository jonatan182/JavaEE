/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bean;

import com.ejb.EJBSaludGuruCitasRemote;
import com.pojo.CitaPojo;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.event.ActionEvent;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.inject.Named;

/**
 *
 * @author jonatanjavier
 */
@Named
@RequestScoped
public class CitaBean {

    @EJB
    private EJBSaludGuruCitasRemote eJBSaludGuruCitas;

    private DataModel citaModel;
    private CitaPojo citaPojo = new CitaPojo();
    private String msg;
    private int estado = 0;

    public void eliminar(ActionEvent e) {
        try {
            //CitaPojo cita = new CitaPojo();
            citaPojo.setIdcita(Integer.parseInt(e.getComponent().getAttributes().get("miden").toString()));
            eJBSaludGuruCitas.Eliminar(citaPojo);
        } catch (Exception ex) {
            System.out.println("Error Al Eliminar Citaaaaa: " + ex.getMessage());
        }

    }

    public void insertar() {
        try {
            /*CitaPojo cita = new CitaPojo();
            MedicoPojo me = new MedicoPojo();
            PacientePojo pa = new PacientePojo();

            me.setIdentificacionmedico(identificacionMedico);
            pa.setIdentificacionpaciente(identificacionPaciente);

            cita.setMedico(me);
            cita.setPaciente(pa);
            cita.setFecha(fecha);
            cita.setHora(hora);*/

            if (estado == 0) {
                eJBSaludGuruCitas.crear(getCitaPojo());
                msg = "Cita Asignada Correctamente";
            } else {
                //cita.setIdcita(idCita);
                eJBSaludGuruCitas.Actualizar(getCitaPojo());
                msg = "Cita Modificada Correctamente";
            }
        } catch (Exception e) {
            msg = "Error Al Asignar Una Cita";
        }
    }

    public void buscar(ActionEvent e) {
        /*setIdentificacionMedico(Integer.parseInt(e.getComponent().getAttributes().get("miden").toString()));
        setIdentificacionPaciente(Integer.parseInt(e.getComponent().getAttributes().get("midenp").toString()));
        setFecha(e.getComponent().getAttributes().get("fec").toString());*/
        //CitaPojo cita = new CitaPojo();
        citaPojo.setIdcita(Integer.parseInt(e.getComponent().getAttributes().get("miden").toString()));
        citaPojo = eJBSaludGuruCitas.buscar(citaPojo);
        setEstado(1);
    }

    public void nuevo() {
        citaPojo.setIdcita(0);
        citaPojo.getMedico().setIdentificacionmedico(0);
        citaPojo.getPaciente().setIdentificacionpaciente(0);
        citaPojo.setFecha("");
        citaPojo.setHora("");
        setEstado(0);
    }

    public DataModel getCitaModel() {

        citaModel = new ListDataModel(eJBSaludGuruCitas.consulta());
        return citaModel;
    }

    /**
     * @param citaModel the citaModel to set
     */
    public void setCitaModel(DataModel citaModel) {
        this.citaModel = citaModel;
    }

    
    /**
     * @return the msg
     */
    public String getMsg() {
        return msg;
    }

    /**
     * @param msg the msg to set
     */
    public void setMsg(String msg) {
        this.msg = msg;
    }

    /**
     * @return the estado
     */
    public int getEstado() {
        return estado;
    }

    /**
     * @param estado the estado to set
     */
    public void setEstado(int estado) {
        this.estado = estado;
    }

    
    /**
     * @return the citaPojo
     */
    public CitaPojo getCitaPojo() {
        return citaPojo;
    }

    /**
     * @param citaPojo the citaPojo to set
     */
    public void setCitaPojo(CitaPojo citaPojo) {
        this.citaPojo = citaPojo;
    }
}
