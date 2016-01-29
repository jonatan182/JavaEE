/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dao;

import com.entityes.Grupos;
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
public class GrupoDao {

    private EntityManagerFactory emf;
    private EntityManager em;

    public GrupoDao() {
        try {
            emf = Persistence.createEntityManagerFactory("PruebaJSF-SqlPU");
            em = emf.createEntityManager();
        } catch (Exception e) {
            System.out.println("Error En La Conexion");
        }
    }

    public List<Grupos> consultaTodosgrupos() {
        List<Grupos> grupos = new ArrayList<Grupos>();
        try {
            Query q = em.createNamedQuery("Grupos.findAll");
            grupos = q.getResultList();
        } catch (Exception e) {
            System.out.println("Error En La Consulta");
        }

        return grupos;

    }
}
