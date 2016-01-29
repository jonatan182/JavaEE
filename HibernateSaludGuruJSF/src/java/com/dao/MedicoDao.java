/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dao;

import com.pojos.Citas;
import com.pojos.Medico;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author Jonatan182
 */
public class MedicoDao {

    private SessionFactory sf;
    private Session s;
    private Transaction ts;
    private String msj;
    public void open() {
        sf = HibernateUtil.getSessionFactory();
        s = sf.openSession();
    }

    public List<Medico> listaMedico() {
        List<Medico> medico = null;
        try {
            open();
            Query q = s.createQuery("SELECT m FROM Medico m");//nota:el nombre de la tabla de la consulta es la clase del pojo, tiene que llamarse igual que el pojo 
            medico = q.list();
        } catch (Exception e) {
            System.out.println("Errorrrrrrrrrrrrrrrrrr: " + e.getMessage());
        }
        return medico;
    }
    public String actualizar(Medico m){
        try {
            open();
            ts = s.beginTransaction();
            s.update(m);
            ts.commit();
            msj="Medico Actualizado";
        } catch (Exception e) {
            msj="Error Al Actualizar Medico";
        }
        return msj;
    }
    public String guardar(Medico m){
        try {
            open();
            ts = s.beginTransaction();
            s.save(m);
            ts.commit();
            msj="Medico Ingresado";
        } catch (Exception e) {
            msj="Error Al Ingresar Medico";
        }
        return msj;
    }
    public String eliminar(Medico m){
        try {
            open();
            ts = s.beginTransaction();
            s.delete(m);
            ts.commit();
            msj = "Eliminacion Correcta";
        } catch (Exception e) {
            msj = "Error Al Eliminar Medico";
        }
        return msj;
    }
    public Medico buscar(Medico m){
        Medico medico = new Medico();
        try {
            open();
            medico = (Medico)s.get(Medico.class, m.getIdMedico());
        } catch (Exception e) {
            msj="Error En La Busqueda";
        }
        return medico;
    }
}
