package com.rest;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.dao.PacienteDao;
import com.pojos.PcientePojo;

@Path("paciente")
public class pacienteRest {

	 private PacienteDao dao = new PacienteDao();

	    @GET
	    @Path("ConsultaAll")
	    @Produces({MediaType.APPLICATION_JSON})//para devolver el servicio en formato json
	    public List<PcientePojo> consularTodos() {
	        /*Paciente pac = new Paciente();
	       List<Paciente> p = new ArrayList<Paciente>();
	       for(Paciente pa : dao.listaPaciente()){
	           System.out.println("Paciente: "+pa.getNombrePaciente()+ "Id: "+pa.getIdPaciente());  
	           pac.setNombrePaciente(pa.getNombrePaciente());
	           p.add(pac);
	       }*/
	        return dao.listaAll();
	    }
	    
	    @GET
	    @Path("ConsultaPaciente/{ide}")
	    @Produces({MediaType.APPLICATION_JSON})//para devolver el servicio en formato json
	    public List<PcientePojo> ConsultaId(@PathParam("ide") Integer ide) {

	        /*Paciente pac = new Paciente();
	       List<Paciente> p = new ArrayList<Paciente>();
	       for(Paciente pa : dao.listaPaciente()){
	           System.out.println("Paciente: "+pa.getNombrePaciente()+ "Id: "+pa.getIdPaciente());  
	           pac.setNombrePaciente(pa.getNombrePaciente());
	           p.add(pac);
	       }*/
	        return dao.consultaPaciente(ide);
	    }
	    @POST
	    @Path("Insertar")
	    @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	    public void create(PcientePojo p) {
	    	System.out.println("Paciente nombre: "+p.getNombrePaciente()+"paciente Edad: "+p.getEdadPaciente());
	        dao.Guardar(p);

	    }

	
}
