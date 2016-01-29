/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dao;

import com.beans.alumno;
import com.entityes.Alumnos;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author Jonatan182
 */
public class AlumnoDao {

    private EntityManager em;
    private EntityManagerFactory emf;
    private String msg;

    public AlumnoDao() {
        try {
            emf = Persistence.createEntityManagerFactory("PruebaJSF-SqlPU");
            em = emf.createEntityManager();
        } catch (Exception e) {
            System.out.println("Error En La Conexion: "+e.getMessage());
        }
    }

    public List<Alumnos> consultaTodosAlumnos() {
        List<Alumnos> alumnos = new ArrayList<Alumnos>();
        try {
            Query sql = em.createNamedQuery("Alumnos.findAll");
            alumnos = sql.getResultList();
        } catch (Exception e) {
            System.out.println("Error En La Consulta");
        }
        return alumnos;
    }
    public Alumnos buscar(Alumnos a){
        Alumnos alumno = new Alumnos();
        List<Alumnos>alumnos;
        try {
            alumno = em.find(Alumnos.class, a.getCodigo());
        } catch (Exception e) {
            System.out.println("Error En La Consulta");
        }
        return alumno;
    }
    
    public String actualizar(Alumnos a){
        try {
            em.getTransaction().begin();
            em.merge(a);
            em.getTransaction().commit();
            em.close();
        } catch (Exception e) {
            em.getTransaction().rollback();
        }
        return msg;
    }
}
