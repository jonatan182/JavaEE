package com.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.PacienteDao;
import com.pojos.PcientePojo;

/**
 * Servlet implementation class consultarPaciente
 */
@WebServlet("/consultarPaciente")
public class consultarPaciente extends HttpServlet {
	private PacienteDao dao;
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public consultarPaciente() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();
		try{
			dao = new PacienteDao();
	        List<PcientePojo> c = dao.listaAll(); 
	       
	        for(PcientePojo tp : c){
                out.println(tp.getIdPaciente()+"<br>"+tp.getNombrePaciente()+"<br>");
                System.out.println("Ass");
            }
	     
		}catch(Exception e){
			System.out.println("Error Servlet: "+e.getMessage());
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
