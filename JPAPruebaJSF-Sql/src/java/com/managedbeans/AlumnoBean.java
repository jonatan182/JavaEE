/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.managedbeans;

import com.beans.alumno;
import com.dao.AlumnoDao;
import com.dao.GrupoDao;
import com.entityes.Alumnos;
import com.entityes.Grupos;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.event.ActionEvent;
import javax.faces.event.ValueChangeEvent;
import javax.faces.model.ListDataModel;
import javax.faces.model.SelectItem;

/**
 *
 * @author Jonatan182
 */
@ManagedBean
@RequestScoped
public class AlumnoBean {

    private ListDataModel<Alumnos> modeloAlumno;
    private AlumnoDao dao;
    private String codigo;
    private String nombre;
    private String apellidos;
    private String direccion;
    private String telefono;
    private Date fechaNacimiento;
    private String nombrePadre;
    private String nombreMadre;
    private String datosBancarios;
    private int edad;
    private int grupo;
    private List<SelectItem> itemsG;

 
    
    public void buscar(ActionEvent e) {
        dao = new AlumnoDao();
        setCodigo(e.getComponent().getAttributes().get("mid").toString());
        Alumnos a = new Alumnos();
        a.setCodigo(getCodigo());
        a = dao.buscar(a);

        if (a != null) {
            setCodigo(a.getCodigo());
            setNombre(a.getNombre());
            setApellidos(a.getApellidos());
            setGrupo(a.getGrupo().getCodigo());
        }
    }

    public void guardar(){
        dao = new AlumnoDao();
        
        Alumnos alumno = new Alumnos();
        alumno.setCodigo(codigo);
        alumno.setNombre(nombre);
        alumno.setApellidos(apellidos);
        
        Grupos g = new Grupos();
        g.setCodigo(grupo);
        alumno.setGrupo(g);
        dao.actualizar(alumno);
    }

    public ListDataModel<Alumnos> getModeloAlumno() {
        dao = new AlumnoDao();
        modeloAlumno = new ListDataModel<Alumnos>(dao.consultaTodosAlumnos());
        return modeloAlumno;
    }

    public List<SelectItem> getItemsG() {
        itemsG = new ArrayList<SelectItem>();
        GrupoDao daog = new GrupoDao();
        for(Grupos g: daog.consultaTodosgrupos()){
            itemsG.add(new SelectItem(g.getCodigo(),g.getCurso().getNumero()+""+g.getLetra()));
        }
        return itemsG;
    }

    public void setItemsG(List<SelectItem> itemsG) {
        this.itemsG = itemsG;
    }

    public void setModeloAlumno(ListDataModel<Alumnos> modeloAlumno) {
        this.modeloAlumno = modeloAlumno;
    }

    public AlumnoDao getDao() {
        return dao;
    }

    public void setDao(AlumnoDao dao) {
        this.dao = dao;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getNombrePadre() {
        return nombrePadre;
    }

    public void setNombrePadre(String nombrePadre) {
        this.nombrePadre = nombrePadre;
    }

    public String getNombreMadre() {
        return nombreMadre;
    }

    public void setNombreMadre(String nombreMadre) {
        this.nombreMadre = nombreMadre;
    }

    public String getDatosBancarios() {
        return datosBancarios;
    }

    public void setDatosBancarios(String datosBancarios) {
        this.datosBancarios = datosBancarios;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public int getGrupo() {
        return grupo;
    }

    public void setGrupo(int grupo) {
        this.grupo = grupo;
    }

}
