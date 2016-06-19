/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rest;

import com.dao.pacienteDao;
import com.entitys.Paciente;
import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import static javax.ws.rs.HttpMethod.PUT;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author xxcin
 */
@Path("paciente")
public class PacienteRest {

    private pacienteDao dao = new pacienteDao();

    @GET
    @Path("ConsultaAll")
    @Produces({MediaType.APPLICATION_JSON})//para devolver el servicio en formato json
    public List<Paciente> consularTodos() {
        /*Paciente pac = new Paciente();
       List<Paciente> p = new ArrayList<Paciente>();
       for(Paciente pa : dao.listaPaciente()){
           System.out.println("Paciente: "+pa.getNombrePaciente()+ "Id: "+pa.getIdPaciente());  
           pac.setNombrePaciente(pa.getNombrePaciente());
           p.add(pac);
       }*/
        return dao.listaPaciente();
    }

    @GET
    @Path("ConsultaPaciente/{ide}")
    @Produces({MediaType.APPLICATION_JSON})//para devolver el servicio en formato json
    public List<Paciente> ConsultaId(@PathParam("ide") Integer ide) {

        /*Paciente pac = new Paciente();
       List<Paciente> p = new ArrayList<Paciente>();
       for(Paciente pa : dao.listaPaciente()){
           System.out.println("Paciente: "+pa.getNombrePaciente()+ "Id: "+pa.getIdPaciente());  
           pac.setNombrePaciente(pa.getNombrePaciente());
           p.add(pac);
       }*/
        return dao.ConsultaPaciente(ide);
    }

    @POST
    @Path("Insertar")
    @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public void create(Paciente p) {
        dao.guardarPaciente(p);

    }

    @DELETE
    @Path("{id}")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public void eliminarPaciente(@PathParam("id") int id) {
        dao.eliminarPaciente(id);
    }

    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public void update(Paciente p) {
        dao.actualizarPaciente(p);
    }
}
