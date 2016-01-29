/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.beans;

import com.dao.MedicoDao;
import com.pojos.Medico;
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
public class MedicosBeans {

    private int idMedico;
    private String nombreMedico;
    private ArrayList<SelectItem> itemsM;
    private MedicoDao daoM;
    private DataModel medicoM;
    private String msj;

    public String getMsj() {
        return msj;
    }

    public void setMsj(String msj) {
        this.msj = msj;
    }
    private int estado = 0;

    public void guardar(){
        daoM = new MedicoDao();
        Medico medico = new Medico();
        medico.setIdMedico(idMedico);
        medico.setNombreMedico(nombreMedico);
        if(estado==0){
            msj = daoM.guardar(medico);
        }else{
            msj = daoM.actualizar(medico);
        }
    }
    
    public void buscar(ActionEvent e) {
        Medico m = new Medico();
        daoM = new MedicoDao();
        m.setIdMedico(Integer.parseInt((e.getComponent().getAttributes().get("mid").toString())));
        m = daoM.buscar(m);
        if (m != null) {
            idMedico = m.getIdMedico();
            nombreMedico = m.getNombreMedico();
            estado = 1;
        }
    }
    public void eliminar(ActionEvent e){
        Medico m = new Medico();
        m.setIdMedico(new Integer(e.getComponent().getAttributes().get("mid").toString()));
        m.setNombreMedico(nombreMedico);
        msj=daoM.eliminar(m);
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }


    public DataModel getMedicoM() {
        daoM = new MedicoDao();
        medicoM = new ListDataModel(daoM.listaMedico());
        return medicoM;
    }

    public void setMedicoM(DataModel medicoM) {
        this.medicoM = medicoM;
    }

    public int getIdMedico() {
        return idMedico;
    }

    public void setIdMedico(int idMedico) {
        this.idMedico = idMedico;
    }

    public ArrayList<SelectItem> getItemsM() {
        itemsM = new ArrayList<SelectItem>();
        daoM = new MedicoDao();
        for (Medico medico : daoM.listaMedico()) {
            itemsM.add(new SelectItem(medico.getIdMedico(), medico.getNombreMedico()));
        }
        return itemsM;
    }

    public void setItemsM(ArrayList<SelectItem> itemsM) {
        this.itemsM = itemsM;
    }

    public MedicosBeans() {
    }

    /**
     * @return the nombreMedico
     */
    public String getNombreMedico() {
        return nombreMedico;
    }

    /**
     * @param nombreMedico the nombreMedico to set
     */
    public void setNombreMedico(String nombreMedico) {
        this.nombreMedico = nombreMedico;
    }

}
