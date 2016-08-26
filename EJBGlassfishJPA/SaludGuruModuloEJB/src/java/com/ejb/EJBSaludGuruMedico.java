/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ejb;

import com.entityes.Medico;
import com.pojo.MedicoPojo;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.naming.InitialContext;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.UserTransaction;

/**
 *
 * @author jonatanjavier
 */
@Stateless
public class EJBSaludGuruMedico implements EJBSaludGuruMedicoRemote {

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
    public void crear(MedicoPojo medico) {
        Medico m = new Medico();
        m.setNombremedico(medico.getNombremedico());
        m.setApellidomedico(medico.getApellidomedico());
        m.setIdentificacionmedico(medico.getIdentificacionmedico());
        m.setEdadmedico(medico.getEdadmedico());
        try {
            open();
            em.getTransaction().begin();
            em.persist(m);
            em.getTransaction().commit();
            System.out.println("Medico Insertado");
        } catch (Exception e) {
            System.out.println("Error Al Insertar medico: " + e.getMessage());

        }
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

    /*  @Override
    public String buscarPrimero() {
        List<Medico> lista = new ArrayList<Medico>();
        String nombre="";
        try {
            open();
            Query q = em.createNamedQuery("Medico.findAll");
            lista =  q.getResultList();
            for(Medico a : lista){
                nombre = a.getNombremedico();
            }
            System.out.println("ConexionExitosa");
        } catch (Exception e) {
            System.out.println("Error En La Consulta");
        }
        return nombre;
    }*/
    @Override
    public List<MedicoPojo> consulta() {
        List<MedicoPojo> lista = new ArrayList<MedicoPojo>();
        List<Medico> listas = new ArrayList<Medico>();
        MedicoPojo medico;
        try {
            open();
            Query q = em.createNamedQuery("Medico.findAll");
            listas = q.getResultList();
            for (Medico m : listas) {
                medico = new MedicoPojo();
                medico.setIdmedico(m.getIdentificacionmedico());
                medico.setNombremedico(m.getNombremedico());
                medico.setApellidomedico(m.getApellidomedico());
                medico.setIdentificacionmedico(m.getIdentificacionmedico());
                medico.setEdadmedico(m.getEdadmedico());
                lista.add(medico);
            }
            close();
        } catch (Exception e) {
            System.out.println("Error En La Consulta");
            close();
        }
        return lista;
    }

    @Override
    public void Eliminar(MedicoPojo medico) {
        try {
            Medico m = new Medico();
            m.setNombremedico(medico.getNombremedico());
            m.setApellidomedico(medico.getApellidomedico());
            m.setIdentificacionmedico(medico.getIdentificacionmedico());
            m.setEdadmedico(medico.getEdadmedico());
            try {
                open();
                m = em.find(Medico.class, medico.getIdentificacionmedico());//tenemos que buscar para poder eliminar en jpa
                em.getTransaction().begin();
                em.remove(m);
                em.getTransaction().commit();
                System.out.println("Medico Eliminado");
                close();
            } catch (Exception e) {
                System.out.println("Error Al Eliminar Medico: " + e.getMessage());
                em.getTransaction().rollback();

            }
        } catch (Exception e) {
        }
    }

    @Override
    public void Actualizar(MedicoPojo medico) {
        Medico m = new Medico();
        m.setIdmedico(medico.getIdmedico());
        m.setNombremedico(medico.getNombremedico());
        m.setApellidomedico(medico.getApellidomedico());
        m.setIdentificacionmedico(medico.getIdentificacionmedico());
        m.setEdadmedico(medico.getEdadmedico());
        try {
            open();
            em.getTransaction().begin();
            em.merge(m);
            em.getTransaction().commit();
            System.out.println("Medico Actualizado");
        } catch (Exception e) {
            System.out.println("Error Al Actualizar Medico: " + e.getMessage());
        }
    }
}
