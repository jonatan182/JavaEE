/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ejb;

import com.entityes.Paciente;
import com.pojo.PacientePojo;
import java.util.ArrayList;
import java.util.List;
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
public class EJBSaludGuruPaciente implements EJBSaludGuruPacienteRemote {
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
    public void crear(PacientePojo Paciente) {
        Paciente p = new Paciente();
        p.setNombrepaciente(Paciente.getNombrepaciente());
        p.setApellidopaciente(Paciente.getApellidopaciente());
        p.setIdentificacionpaciente(Paciente.getIdentificacionpaciente());
        p.setEdad(Paciente.getEdad());
        try {
            open();
            em.getTransaction().begin();
            em.persist(p);
            em.getTransaction().commit();
            System.out.println("Paciente Insertado");
        } catch (Exception e) {
            System.out.println("Error Al Insertar Paciente: " + e.getMessage());

        }
    }

    @Override
    public List<PacientePojo> consulta() {
        List<PacientePojo> lista = new ArrayList<PacientePojo>();
        List<Paciente> listas = new ArrayList<Paciente>();
        PacientePojo Paciente;
        try {
            open();
            Query q = em.createNamedQuery("Paciente.findAll");
            listas = q.getResultList();
            for (Paciente m : listas) {
                Paciente = new PacientePojo();
                Paciente.setIdpaciente(m.getIdpaciente());
                Paciente.setNombrepaciente(m.getNombrepaciente());
                Paciente.setApellidopaciente(m.getApellidopaciente());
                Paciente.setIdentificacionpaciente(m.getIdentificacionpaciente());
                Paciente.setEdad(m.getEdad());
                lista.add(Paciente);
            }
            close();
        } catch (Exception e) {
            System.out.println("Error En La Consulta");
            close();
        }
        return lista;
    }

    @Override
    public void Eliminar(PacientePojo Paciente) {
        try {
            Paciente p = new Paciente();
            p.setNombrepaciente(Paciente.getNombrepaciente());
            p.setApellidopaciente(Paciente.getApellidopaciente());
            p.setIdentificacionpaciente(Paciente.getIdentificacionpaciente());
            p.setEdad(Paciente.getEdad());
            try {
                open();
                p = em.find(Paciente.class, Paciente.getIdentificacionpaciente());//tenemos que buscar para poder eliminar en jpa
                em.getTransaction().begin();
                em.remove(p);
                em.getTransaction().commit();
                System.out.println("Paciente Eliminado");
                close();
            } catch (Exception e) {
                System.out.println("Error Al Eliminar Paciente: " + e.getMessage());
                em.getTransaction().rollback();

            }
        } catch (Exception e) {
        }
    }

    @Override
    public void Actualizar(PacientePojo Paciente) {
        Paciente p = new Paciente();
        p.setIdpaciente(Paciente.getIdpaciente());
        p.setNombrepaciente(Paciente.getNombrepaciente());
        p.setApellidopaciente(Paciente.getApellidopaciente());
        p.setIdentificacionpaciente(Paciente.getIdentificacionpaciente());
        p.setEdad(Paciente.getEdad());
        try {
            open();
            em.getTransaction().begin();
            em.merge(p);
            em.getTransaction().commit();
            System.out.println("Paciente Actualizado");
        } catch (Exception e) {
            System.out.println("Error Al Actualizar Paciente: " + e.getMessage());
        }
    }
}
