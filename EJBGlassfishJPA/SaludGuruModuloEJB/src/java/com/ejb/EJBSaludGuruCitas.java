/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ejb;

import com.entityes.Cita;
import com.entityes.Medico;
import com.entityes.Paciente;
import com.pojo.CitaPojo;
import com.pojo.MedicoPojo;
import com.pojo.PacientePojo;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author jonatanjavier
 */
@Stateless
public class EJBSaludGuruCitas implements EJBSaludGuruCitasRemote {

    private EntityManagerFactory emf;
    private EntityManager em;

    public void open() {
        try {
            emf = Persistence.createEntityManagerFactory("SaludGuruModuloEJBPU");
            em = emf.createEntityManager();
            System.out.println("Conexion Exitosa");
        } catch (Exception e) {
            System.out.println("Error En La Conexion: " + e.getMessage());
        }
    }

    public void close() {
        try {
            em.close();
            emf.close();
            System.out.println("Conexion Cerrada");
        } catch (Exception e) {
        }
    }

    @Override
    public void crear(CitaPojo c) {
        try {
            Medico me = new Medico();
            Paciente pa = new Paciente();
            Cita cita = new Cita();
            me.setIdentificacionmedico(c.getMedico().getIdentificacionmedico());

            pa.setIdentificacionpaciente(c.getPaciente().getIdentificacionpaciente());

            SimpleDateFormat formatterF = new SimpleDateFormat("yyyy/MM/dd");//Para convertir de String a Date fecha
            cita.setFecha(formatterF.parse(c.getFecha()));

            SimpleDateFormat formatterH = new SimpleDateFormat("HH:mm:ss");//Para convertir de String a Date Hora
            cita.setHora(formatterH.parse(c.getHora()));

            cita.setIdentificacionmedico(me);
            cita.setIdentificacionpaciente(pa);
            System.out.println("Citaaaa: " + cita.getFecha() + " " + cita.getHora() + " " + " " + cita.getIdentificacionmedico().getIdentificacionmedico() + " " + cita.getIdentificacionpaciente());

            open();
            em.getTransaction().begin();
            em.persist(cita);
            em.getTransaction().commit();
            close();

        } catch (Exception ex) {
            System.out.println("Erroooor Al Asignar Citaa: " + ex.getMessage());

        }
    }

    @Override
    public List<CitaPojo> consulta() {
        List<CitaPojo> lista = new ArrayList<CitaPojo>();
        List<Cita> listas = new ArrayList<Cita>();
        CitaPojo cita;
        MedicoPojo me;
        PacientePojo pa;
        try {
            open();
            Query q = em.createNamedQuery("Cita.findAll");
            listas = q.getResultList();
            for (Cita c : listas) {
                me = new MedicoPojo();
                pa = new PacientePojo();

                me.setIdmedico(c.getIdentificacionmedico().getIdentificacionmedico());
                me.setEdadmedico(c.getIdentificacionmedico().getEdadmedico());
                me.setIdentificacionmedico(c.getIdentificacionmedico().getIdentificacionmedico());
                me.setNombremedico(c.getIdentificacionmedico().getNombremedico());
                me.setApellidomedico(c.getIdentificacionmedico().getApellidomedico());

                pa.setIdpaciente(c.getIdentificacionpaciente().getIdpaciente());
                pa.setNombrepaciente(c.getIdentificacionpaciente().getNombrepaciente());
                pa.setApellidopaciente(c.getIdentificacionpaciente().getApellidopaciente());
                pa.setIdentificacionpaciente(c.getIdentificacionpaciente().getIdentificacionpaciente());
                pa.setEdad(c.getIdentificacionpaciente().getEdad());

                cita = new CitaPojo();
                DateFormat fechaHora = new SimpleDateFormat("yyyy/MM/dd");//para convertir de Date A String fecha

                cita.setIdcita(c.getIdcita());
                cita.setFecha(fechaHora.format(c.getFecha()));

                fechaHora = new SimpleDateFormat("HH:mm:ss");//para convertir de date A String hora
                cita.setHora(fechaHora.format(c.getHora()));

                cita.setMedico(me);
                cita.setPaciente(pa);
                lista.add(cita);
            }
            close();
        } catch (Exception e) {
            System.out.println("Error En La Consulta:" + e.getMessage());
            close();
        }
        return lista;
    }

    @Override
    public void Eliminar(CitaPojo cita) {
        Cita objc;
        try {
            open();
            objc = em.find(Cita.class, cita.getIdcita());
            em.getTransaction().begin();
            em.remove(objc);
            em.getTransaction().commit();
            close();
        } catch (Exception e) {
            System.out.println("Errorrrr: " + e.getMessage());
        }
    }

    @Override
    public void Actualizar(CitaPojo c) {
        try {
            Medico me = new Medico();
            Paciente pa = new Paciente();
            Cita cita = new Cita();
            me.setIdentificacionmedico(c.getMedico().getIdentificacionmedico());

            pa.setIdentificacionpaciente(c.getPaciente().getIdentificacionpaciente());

            SimpleDateFormat formatterF = new SimpleDateFormat("yyyy/MM/dd");//Para convertir de String a Date fecha
            cita.setFecha(formatterF.parse(c.getFecha()));

            SimpleDateFormat formatterH = new SimpleDateFormat("HH:mm:ss");//Para convertir de String a Date Hora
            cita.setHora(formatterH.parse(c.getHora()));

            cita.setIdcita(c.getIdcita());
            cita.setIdentificacionmedico(me);
            cita.setIdentificacionpaciente(pa);
            System.out.println(cita.getFecha() + " " + cita.getHora() + " " + " " + cita.getIdentificacionmedico().getIdentificacionmedico() + " " + cita.getIdentificacionpaciente());

            open();
            em.getTransaction().begin();
            em.merge(cita);
            em.getTransaction().commit();
            close();

        } catch (Exception ex) {
            System.out.println("Erroooor Al Actualizar Citaa: " + ex.getMessage());

        }
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    @Override
    public CitaPojo buscar(CitaPojo c) {
        Cita cita = new Cita();
        CitaPojo ci = new CitaPojo();
        MedicoPojo me = new MedicoPojo();
        PacientePojo pa = new PacientePojo();
        try {
            open();
            em.getTransaction().begin();
            cita.setIdcita(c.getIdcita());
            cita = em.find(Cita.class, cita.getIdcita());
            ci.setIdcita(cita.getIdcita());

            me.setIdentificacionmedico(cita.getIdentificacionmedico().getIdentificacionmedico());
            pa.setIdentificacionpaciente(cita.getIdentificacionpaciente().getIdentificacionpaciente());
            ci.setMedico(me);
            ci.setPaciente(pa);

            DateFormat fechaHora = new SimpleDateFormat("yyyy/MM/dd");//para convertir de Date A String fecha

          
            ci.setFecha(fechaHora.format(cita.getFecha()));

            fechaHora = new SimpleDateFormat("HH:mm:ss");//para convertir de date A String hora
            ci.setHora(fechaHora.format(cita.getHora()));

        } catch (Exception e) {
            System.out.println("Error En La Busqueda: " + e.getMessage());
        }
        return ci;

    }
}
