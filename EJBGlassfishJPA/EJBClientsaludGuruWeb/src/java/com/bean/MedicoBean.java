/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bean;

import com.pojo.MedicoPojo;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import com.ejb.EJBSaludGuruMedicoRemote;
import java.util.ArrayList;
import javax.faces.event.ActionEvent;
import javax.faces.model.SelectItem;

/**
 *
 * @author jonatanjavier
 */
@Named(value = "medicoBean")
@RequestScoped
public class MedicoBean {

    @EJB
    private EJBSaludGuruMedicoRemote eJBSaludGuru;

    private DataModel<MedicoPojo> modelo;
    private MedicoPojo medicoPojo = new MedicoPojo();
    private int estado = 0;
    private ArrayList<SelectItem> itemMedico;

    public MedicoBean() {
    }

    public void guardar() {
        System.out.println("identificacion: " + medicoPojo.getIdentificacionmedico());
        if (estado == 0) {
            eJBSaludGuru.crear(medicoPojo);
        } else {
            eJBSaludGuru.Actualizar(medicoPojo);
        }

    }

    public void eliminar(ActionEvent e) {
        try {
            MedicoPojo medico = new MedicoPojo();
            medico.setIdentificacionmedico(new Integer(e.getComponent().getAttributes().get("mid").toString()));
            eJBSaludGuru.Eliminar(medico);
        } catch (Exception es) {
            System.out.println("Error Al Eliminar Medico: " + es.getMessage());
        }
    }

    public void buscar(ActionEvent e) {
        try {
            MedicoPojo medico = new MedicoPojo();
            List<MedicoPojo> medicoLista = new ArrayList<MedicoPojo>();
            medico.setIdentificacionmedico(new Integer(e.getComponent().getAttributes().get("mid").toString()));
            medicoLista = eJBSaludGuru.consulta();
            for (MedicoPojo m : medicoLista) {
                if (m.getIdentificacionmedico().intValue() == medico.getIdentificacionmedico().intValue()) {
                    medicoPojo.setIdmedico(m.getIdmedico());
                    medicoPojo.setIdentificacionmedico(m.getIdentificacionmedico());
                    medicoPojo.setNombremedico(m.getNombremedico());
                    medicoPojo.setApellidomedico(m.getApellidomedico());
                    medicoPojo.setEdadmedico(m.getEdadmedico());
                    estado = 1;
                }
            }
        } catch (Exception es) {
            System.out.println("Error Al Eliminar Medico: " + es.getMessage());
        }
    }

    public void nuevo() {
        medicoPojo.setIdmedico(0);
        medicoPojo.setIdentificacionmedico(0);
        medicoPojo.setNombremedico("");
        medicoPojo.setApellidomedico("");
        medicoPojo.setEdadmedico(0);
        setEstado(0);

    }

    public DataModel<MedicoPojo> getModelo() {

        modelo = new ListDataModel<MedicoPojo>(eJBSaludGuru.consulta());
        return modelo;
    }

    public void setModelo(DataModel modelo) {
        this.modelo = modelo;
    }

    /**
     * @return the medicoPojo
     */
    public MedicoPojo getMedicoPojo() {
        return medicoPojo;
    }

    /**
     * @param medicoPojo the medicoPojo to set
     */
    public void setMedicoPojo(MedicoPojo medicoPojo) {
        this.medicoPojo = medicoPojo;
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
     * @return the itemMedico
     */
    public ArrayList<SelectItem> getItemMedico() {
        itemMedico = new ArrayList<SelectItem>();
        for (MedicoPojo m : eJBSaludGuru.consulta()) {
            itemMedico.add(new SelectItem(m.getIdentificacionmedico(), m.getNombremedico()));
        }
        return itemMedico;
    }

    /**
     * @param itemMedico the itemMedico to set
     */
    public void setItemMedico(ArrayList<SelectItem> itemMedico) {
        this.itemMedico = itemMedico;
    }

}
