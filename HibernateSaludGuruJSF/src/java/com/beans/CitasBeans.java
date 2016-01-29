/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.beans;

import com.dao.CitasDao;
import com.pojos.Citas;
import com.pojos.Medico;
import com.pojos.Paciente;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.event.ActionEvent;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;

/**
 *
 * @author Jonatan182
 */
@ManagedBean
@RequestScoped
public class CitasBeans {

    private DataModel citasModelo;
    private CitasDao dao = new CitasDao();
    private int idCita;
    private Medico medico;
    private Paciente paciente;
    private String fecha;
    private int idMedico;
    private int idPaciente;
    private int estado = 0;
    private String msj;
    private Date fechaF;
    private DataModel medicoConsulta;
    private int valorCita;

    public int getValorCita() {
        return valorCita;
    }

    public void setValorCita(int valorCita) {
        this.valorCita = valorCita;
    }
    public void guardar(ActionEvent ae) {
        try {
            Citas cita = new Citas();
            Medico medico = new Medico();
            Paciente paciente = new Paciente();

            cita.setIdCita(idCita);
            medico.setIdMedico(idMedico);
            cita.setMedico(medico);
            paciente.setIdPaciente(idPaciente);
            cita.setPaciente(paciente);
            cita.setHoraCita(getFechaF());
            if (estado == 0) {
                dao = new CitasDao();
                msj = dao.guardar(cita);
            } else {
                dao = new CitasDao();
                msj = dao.actualizar(cita);
            }
        } catch (Exception e) {
            msj = "Error Al Asignar Cita: " + e.getMessage();
        }

    }

    public void buscar(ActionEvent ae) {
        Citas cita = new Citas();
        cita.setIdCita(Integer.parseInt(ae.getComponent().getAttributes().get("mid").toString()));
        cita = dao.buscar(cita);
        if (cita != null) {
            idCita = cita.getIdCita();
            idMedico = cita.getMedico().getIdMedico();
            idPaciente = cita.getPaciente().getIdPaciente();
            fechaF = cita.getHoraCita();
            fecha = fechaF + "";
            estado = 1;
        }

    }

    public void eliminar(ActionEvent e) {
        Citas c = new Citas();
        c.setIdCita(Integer.parseInt(e.getComponent().getAttributes().get("mid").toString()));
        msj = dao.eliminar(c);
    }

    public DataModel getMedicoConsulta() {
        Citas c = new Citas();
        Medico m = new Medico();
        m.setIdMedico(idMedico);
        c.setMedico(m);
      
        medicoConsulta = new ListDataModel(dao.consultaCitasMedico(c,fecha));
        
        return medicoConsulta;
    }

    public void setMedicoConsulta(DataModel medicoConsulta) {
        this.medicoConsulta = medicoConsulta;
    }

    public Date getFechaF() {
        try {
            DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.S");//lo inidcamos el formato de esta forma con guiony empezando por año-mes-dia  por que el wamp lo recibe de esta forma. en mysql lo recibe con "/"
            fechaF = df.parse(getFecha());
        } catch (Exception e) {
            System.out.println("Error En La Fecha");
        }
        return fechaF;
    }

    public void setFechaF(Date fechaF) {
        this.fechaF = fechaF;
    }

    public String getMsj() {
        return msj;
    }

    public void setMsj(String msj) {
        this.msj = msj;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public int getIdMedico() {
        return idMedico;
    }

    public void setIdMedico(int idMedico) {
        this.idMedico = idMedico;
    }

    public int getIdPaciente() {
        return idPaciente;
    }

    public void setIdPaciente(int idPaciente) {
        this.idPaciente = idPaciente;
    }

    public int getIdCita() {
        return idCita;
    }

    public void setIdCita(int idCita) {
        this.idCita = idCita;
    }

    public Medico getMedico() {
        return medico;
    }

    public void setMedico(Medico medico) {
        this.medico = medico;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public DataModel getCitasModelo() {
        dao = new CitasDao();
        citasModelo = new ListDataModel<Citas>(dao.listaCitas());
        return citasModelo;
    }

    public void setCitasModelo(DataModel citasModelo) {
        this.citasModelo = citasModelo;
    }

    public CitasBeans() {
    }

}
