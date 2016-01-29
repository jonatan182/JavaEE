/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dao;

import com.pojos.Paciente;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author Jonatan182
 */
public class PacienteDao {

    private SessionFactory sf;
    private Session s;
    private Transaction ts;
    private String msj;

    public void open() {
        sf = HibernateUtil.getSessionFactory();
        s = sf.openSession();
    }

    public String guardar(Paciente p){
        try {
            open();
            ts = s.beginTransaction();
            s.save(p);
            ts.commit();
            msj="Paciente Guardado Satisfactoriamente!!";
        } catch (Exception e) {
            msj="Error Al Guardar El Paciente: "+e.getMessage();
        }
        return msj;
    }
    public String eliminar(Paciente p){
        Paciente paciente;
        try {
            open();
            ts = s.beginTransaction();
            paciente = (Paciente)s.get(Paciente.class, p.getIdPaciente());
            if(paciente!=null){
                s.delete(paciente);
                ts.commit();
                msj="Paciente Eliminado Correctamente";
            }
        } catch (Exception e) {
            System.out.println("Error Al Eliminar Paciente");
            msj="Error Al Eliminar Paciente";
        }
        
        return msj;
    }
    public String actualizar(Paciente p) {
        try {
            open();
            ts = s.beginTransaction();
            s.update(p);
            ts.commit();
            msj = "Paciente Actualizado SatisFactoriamente!!";
        } catch (Exception e) {
            System.out.println("Error Al Actualizar Paciente: " + e.getMessage());
            msj = "Error Al Actualizar Paciente: " + e.getMessage();
        }
        return msj;
    }

    public List<Paciente> listaPaciente() {
        List<Paciente> paciente = null;
        try {
            open();
            Query q = s.createQuery("SELECT p FROM Paciente p");//nota:el nombre de la tabla de la consulta es la clase del pojo, tiene que llamarse igual que el pojo 
            paciente = q.list();
        } catch (Exception e) {
            System.out.println("Errorrrrrrrrrrrrrrrrrr: " + e.getMessage());
        }
        return paciente;
    }

    public Paciente buscar(Paciente p) {
        Paciente paciente = new Paciente();
        try {
            open();
            ts = s.beginTransaction();
            paciente = (Paciente) s.get(Paciente.class, p.getIdPaciente());
            ts.commit();
        } catch (Exception e) {
            System.out.println("Error En La Busqueda: " + e.getMessage());
        }
        return paciente;
    }
}
