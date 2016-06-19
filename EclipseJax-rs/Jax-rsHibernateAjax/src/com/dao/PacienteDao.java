package com.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.pojos.PcientePojo;



public class PacienteDao {
	private SessionFactory factory;
	private Session session;
	private Transaction t;
	
public void open(){
	//creating configuration object
		Configuration cfg=new Configuration();
		cfg.configure("hibernate.cfg.xml");//populates the data of the configuration file
		
		//creating seession factory object
		factory=cfg.buildSessionFactory();
		
		//creating session object
		session=factory.openSession();
		System.out.println("Conexion Exitosa");
		
		//creating transaction object
	    
}
public void close() {
    factory.close();
    session.close();
}

	
	public void Guardar(PcientePojo e1){
		try {
			open();
   
		    t=session.beginTransaction();  
		    session.persist(e1);//persisting the object   
		    t.commit();//transaction is committed    
		    System.out.println("successfully saved");  
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Error Al Guadar: "+e.getMessage());
			t.rollback();
		
		}
			      
			 
	

}
	public List<PcientePojo> listaAll(){
		List<PcientePojo> tc = null;
		try {
			open();    
			Query q = session.createQuery("SELECT C FROM PcientePojo C"); 
			tc = q.list();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Error store: "+e.getMessage());
			t.rollback();
		}
		return tc;
	}
	
	public List<PcientePojo> consultaPaciente(Integer id){
		
		List<PcientePojo> tc = null;
		try {
			open();
			Query q = session.createQuery("SELECT C FROM PcientePojo C WHERE C.idPaciente="+id); 
			tc = q.list();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Error consulta: "+e.getMessage());
			t.rollback(); 
		}
		return tc;
	}
}