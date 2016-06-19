/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dao;

import com.entitys.Paciente;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author xxcin
 */
public class pacienteDao {

    private SessionFactory sf = null;
    private Session s = null;
    private Transaction ts = null;
    private String msj;

    public void open() {
        try {
            sf = HibernateUtil.getSessionFactory();//creamos la session
            s = sf.openSession();//abrimos una nueva session
        } catch (Exception e) {
            System.out.println("Error En La Conexion");
        }

    }

    public void close() {
        s.close();
        sf.close();
    }

    public void guardarPaciente(Paciente p) {
        try {
            open();
            ts = s.beginTransaction();
            s.save(p);
            ts.commit();
            System.out.println("Paciente Guardado");
        } catch (Exception e) {
            System.out.println("Error Al Guardar Paciente: " + e.getMessage());
        }
    }

    public List<Paciente> listaPaciente() {
        List<Paciente> paciente = new ArrayList<Paciente>();
        Paciente pa;
        try {
            open();
            Query q = s.createQuery("SELECT C.idPaciente, C.nombrePaciente FROM Paciente C");//nota:el nombre de la tabla de la consulta es la clase del pojo, tiene que llamarse igual que el pojo 
            System.out.println("ssssssssssssssssa");

            List<Object> result = (List<Object>) q.list();
            Iterator itr = result.iterator();
            while (itr.hasNext()) {
                pa = new Paciente();
                Object[] obj = (Object[]) itr.next();
                pa.setIdPaciente(Integer.parseInt(String.valueOf(obj[0])));
                pa.setNombrePaciente(String.valueOf(obj[1]));
                //now you have one array of Object for each row
                paciente.add(pa);
            }

        } catch (Exception e) {
            System.out.println("Errorrrrrrrrrrrrrrrrrr: " + e.getMessage());
        }
        return paciente;
    }

    public List<Paciente> ConsultaPaciente(Integer p) {
        List<Paciente> paciente = new ArrayList<Paciente>();
        Paciente pa;
        try {
            open();
            Query q = s.createQuery("SELECT C.idPaciente, C.nombrePaciente FROM Paciente C where C.idPaciente=" + p);//nota:el nombre de la tabla de la consulta es la clase del pojo, tiene que llamarse igual que el pojo 
            System.out.println("ssssssssssssssssa");

            List<Object> result = (List<Object>) q.list();
            Iterator itr = result.iterator();
            while (itr.hasNext()) {
                pa = new Paciente();
                Object[] obj = (Object[]) itr.next();
                pa.setIdPaciente(Integer.parseInt(String.valueOf(obj[0])));
                pa.setNombrePaciente(String.valueOf(obj[1]));
                //now you have one array of Object for each row
                paciente.add(pa);
            }

        } catch (Exception e) {
            System.out.println("Errorrrrrrrrrrrrrrrrrr: " + e.getMessage());
        }
        return paciente;
    }

    public void eliminarPaciente(Integer id) {
        try {
            open();

            ts = s.beginTransaction();
            Paciente paciente = (Paciente) s.get(Paciente.class, id);
            if (paciente != null) {
                s.delete(paciente);
                ts.commit();
            } else {
                System.out.println("Pacinte No Registrado");
            }
        } catch (Exception e) {
            System.out.println("Error Al Eliminar Paciente: " + e.getMessage());
        }
    }

    public void actualizarPaciente(Paciente p) {
        try {
            open();
            ts = s.beginTransaction();

            s.update(p);
            ts.commit();

            System.out.println("Pacinte No Registrado");

        } catch (Exception e) {
            System.out.println("Error Al Actualizar Paciente: " + e.getMessage());
        }
    }
}
