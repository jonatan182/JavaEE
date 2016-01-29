/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.beans;

import com.dao.PacienteDao;
import com.pojos.Paciente;
import java.util.ArrayList;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.event.ActionEvent;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.faces.model.SelectItem;

/**
 *
 * @author Jonatan182
 */
@ManagedBean
@RequestScoped
public class PacienteBeans {

    private ArrayList<SelectItem> itemsP;
    private PacienteDao daoP = new PacienteDao();
    private DataModel pacienteModelo;
    private int estado = 0;
    private int idPaciente;
    private String nombrePaciente;
    private int edadPaciente;
    private String seguro;
    private String msj;

    public void guardar() {
        Paciente p = new Paciente();
        p.setIdPaciente(idPaciente);
        p.setNombrePaciente(nombrePaciente);
        p.setEdadPaciente(edadPaciente);
        p.setSeguro(seguro);
        if (estado == 0) {
            msj = daoP.guardar(p);
        } else {
            msj = daoP.actualizar(p);
        }
    }

    public void buscar(ActionEvent e) {
        Paciente p = new Paciente();
        p.setIdPaciente(new Integer(e.getComponent().getAttributes().get("mid").toString()));
        p = daoP.buscar(p);
        idPaciente = p.getIdPaciente();
        nombrePaciente = p.getNombrePaciente();
        edadPaciente = p.getEdadPaciente();
        seguro = p.getSeguro();
        estado = 1;
    }
    public void eliminar(ActionEvent e){
        Paciente p = new Paciente();
        p.setIdPaciente(new Integer(e.getComponent().getAttributes().get("mid").toString()));
        msj=daoP.eliminar(p);
    }

    public DataModel getPacienteModelo() {
        pacienteModelo = new ListDataModel(daoP.listaPaciente());
        return pacienteModelo;
    }

    public void setPacienteModelo(DataModel pacienteModelo) {
        this.pacienteModelo = pacienteModelo;
    }

    public ArrayList<SelectItem> getItemsP() {
        itemsP = new ArrayList<SelectItem>();
        daoP = new PacienteDao();
        for (Paciente p : daoP.listaPaciente()) {
            itemsP.add(new SelectItem(p.getIdPaciente(), p.getNombrePaciente()));
        }
        return itemsP;
    }

    public String getMsj() {
        return msj;
    }

    public void setMsj(String msj) {
        this.msj = msj;
    }

    public void setItemsP(ArrayList<SelectItem> itemsP) {
        this.itemsP = itemsP;
    }

    public PacienteBeans() {
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public int getIdPaciente() {
        return idPaciente;
    }

    public void setIdPaciente(int idPaciente) {
        this.idPaciente = idPaciente;
    }

    public String getNombrePaciente() {
        return nombrePaciente;
    }

    public void setNombrePaciente(String nombrePaciente) {
        this.nombrePaciente = nombrePaciente;
    }

    public int getEdadPaciente() {
        return edadPaciente;
    }

    public void setEdadPaciente(int edadPaciente) {
        this.edadPaciente = edadPaciente;
    }

    public String getSeguro() {
        return seguro;
    }

    public void setSeguro(String seguro) {
        this.seguro = seguro;
    }
}
