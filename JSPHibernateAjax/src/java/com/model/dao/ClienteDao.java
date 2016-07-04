/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.model.dao;

import java.util.*;
import com.model.pojos.*;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class ClienteDao {

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
     public List<Cliente> listaCliente() {
        List<Cliente> cliente = null;
        try {
            open();
            Query q = s.createQuery("SELECT C FROM Cliente C");//nota:el nombre de la tabla de la consulta es la clase del pojo, tiene que llamarse igual que el pojo 
            cliente = q.list();
        } catch (Exception e) {
            System.out.println("Errorrrrrrrrrrrrrrrrrr: " + e.getMessage());
        }
        return cliente;
    }
    //metodo para insertar objeto como tupla en la BD
   public String guardar(Cliente c) {
        try {
            open();
            ts = s.beginTransaction();
            s.save(c);
            ts.commit();
            msj = "Cliente Asignada";
        } catch (Exception e) {
            msj = "Error Al Asignar La Cliente: " + e.getMessage();
        }
        return msj;
    }
}
