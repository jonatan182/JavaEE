/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bean;

import com.ejb.EJBSaludGuruPacienteRemote;
import com.pojo.PacientePojo;
import com.pojo.PacientePojo;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.event.ActionEvent;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.faces.model.SelectItem;
import javax.inject.Named;

/**
 *
 * @author jonatanjavier
 */
@Named(value = "pacienteBean")
@RequestScoped
public class PacienteBean {

    @EJB
    private EJBSaludGuruPacienteRemote eJBSaludGuruPaciente;
    private DataModel<PacientePojo> pacienteModelo;
    private PacientePojo pacientePojo = new PacientePojo();
    private ArrayList<SelectItem> itemP;
    private int estado = 0;
    private String msg;

    public void insertar() {
        try {
            if (estado == 1) {
                   System.out.println("idddd:  " + pacientePojo.getIdpaciente()+"  "+pacientePojo.getNombrepaciente());
                eJBSaludGuruPaciente.Actualizar(pacientePojo);
            } else {
             
                eJBSaludGuruPaciente.crear(pacientePojo);
            }
        } catch (Exception e) {
            msg = "Error Al Insetar Paciente: " + e.getMessage();
        }
    }

    public void eliminar(ActionEvent e) {
        try {
            PacientePojo paciente = new PacientePojo();
            paciente.setIdentificacionpaciente(new Integer(e.getComponent().getAttributes().get("idP").toString()));
            eJBSaludGuruPaciente.Eliminar(paciente);
        } catch (Exception es) {
            System.out.println("Error Al Eliminar Paciente: " + es.getMessage());
        }
    }

    public void buscar(ActionEvent e) {

        PacientePojo paciente = new PacientePojo();
        paciente.setIdentificacionpaciente(new Integer(e.getComponent().getAttributes().get("idP").toString()));
        try {
            List<PacientePojo> pacienteLista;
            pacienteLista = eJBSaludGuruPaciente.consulta();
            for (PacientePojo m : pacienteLista) {
                if (m.getIdentificacionpaciente().intValue() == paciente.getIdentificacionpaciente().intValue()) {
                    System.out.println("Id::::::: " + m.getIdpaciente());
                    pacientePojo.setIdpaciente(m.getIdpaciente());
                    pacientePojo.setIdentificacionpaciente(m.getIdentificacionpaciente());
                    pacientePojo.setNombrepaciente(m.getNombrepaciente());
                    pacientePojo.setApellidopaciente(m.getApellidopaciente());
                    pacientePojo.setEdad(m.getEdad());
                    setEstado(1);
                }
            }
        } catch (Exception es) {
            System.out.println("Error Al Eliminar Paciente: " + es.getMessage());
        }

    }

    /**
     * @return the itemP
     */
    public ArrayList<SelectItem> getItemP() {
        itemP = new ArrayList<SelectItem>();
        for (PacientePojo p : eJBSaludGuruPaciente.consulta()) {
            itemP.add(new SelectItem(p.getIdentificacionpaciente(), p.getNombrepaciente()));
        }
        return itemP;
    }

    /**
     * @param itemP the itemP to set
     */
    public void setItemP(ArrayList<SelectItem> itemP) {
        this.itemP = itemP;
    }

    /**
     * @return the pacientePojo
     */
    public PacientePojo getPacientePojo() {
        return pacientePojo;
    }

    /**
     * @param pacientePojo the pacientePojo to set
     */
    public void setPacientePojo(PacientePojo pacientePojo) {
        this.pacientePojo = pacientePojo;
    }

    /**
     * @return the pacienteModelo
     */
    public DataModel<PacientePojo> getPacienteModelo() {
        pacienteModelo = new ListDataModel<PacientePojo>(eJBSaludGuruPaciente.consulta());
        return pacienteModelo;
    }

    /**
     * @param pacienteModelo the pacienteModelo to set
     */
    public void setPacienteModelo(DataModel<PacientePojo> pacienteModelo) {
        this.pacienteModelo = pacienteModelo;
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
}
