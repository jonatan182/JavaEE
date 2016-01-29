/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dao;

import com.pojos.Citas;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author Jonatan182
 */
public class CitasDao {

    private SessionFactory sf;
    private Session s;
    private Transaction ts;
    private String msj;

    public void open() {
        sf = HibernateUtil.getSessionFactory();
        s = sf.openSession();
    }

    public void close() {
        s.close();
        sf.close();
    }

    public List<Citas> listaCitas() {
        List<Citas> citas = null;
        try {
            open();
            Query q = s.createQuery("SELECT C FROM Citas C");//nota:el nombre de la tabla de la consulta es la clase del pojo, tiene que llamarse igual que el pojo 
            citas = q.list();
        } catch (Exception e) {
            System.out.println("Errorrrrrrrrrrrrrrrrrr: " + e.getMessage());
        }
        return citas;
    }

    public Citas buscar(Citas c) {
        Citas citas = null;
        try {
            open();
            citas = (Citas) s.get(Citas.class, c.getIdCita());
        } catch (Exception e) {
        }
        return citas;
    }

    public String actualizar(Citas c) {
        try {
            open();
            ts = s.beginTransaction();
            s.update(c);
            ts.commit();
            msj = "Cita Actualizada";
        } catch (Exception e) {
            msj = "Error Al Actualizar La Cita: " + e.getMessage();
        }
        return msj;
    }

    public String guardar(Citas c) {
        try {
            open();
            ts = s.beginTransaction();
            s.save(c);
            ts.commit();
            msj = "Cita Asignada";
        } catch (Exception e) {
            msj = "Error Al Asignar La Cita: " + e.getMessage();
        }
        return msj;
    }

    public String eliminar(Citas c) {
        try {
            open();
            ts = s.beginTransaction();
            Citas cita = (Citas) s.get(Citas.class, c.getIdCita());//es opcional en este caso, pero en la mayoria de veces tenemos que indicarlo para buscar y hay si eliminar
            if (cita != null) {
                s.delete(cita);
                ts.commit();
                msj = "Cita Eliminada!!";
            } else {
                msj = "Cita No Encontrada";
            }
        } catch (Exception e) {
            msj = "Error Al Eliminar La Cita: " + e.getMessage();
        }
        return msj;
    }

    public List<Citas> consultaCitasMedico(Citas c, String fecha) {
        List<Citas> citas = null;
        try {
            open();
            Query q = s.createQuery("SELECT c FROM Citas c WHERE c.horaCita LIKE '" + fecha + "%' AND c.medico.idMedico="+c.getMedico().getIdMedico());
            citas = q.list();
        } catch (Exception e) {
            System.out.println("Error En La Consulta De Las Citas Del Medico: " + e.getMessage());
        }
        return citas;
    }
}
