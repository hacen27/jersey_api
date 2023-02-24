package com.api;

import jakarta.transaction.Transactional;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;


import com.api.dao.EtudiantDAO;
import com.api.dao.EmployeeDAO;
import com.api.entity.Employee;
import com.api.entity.Etudiant;
import java.util.List;



//import jakarta.websocket.server.PathParam;
import jakarta.ws.rs.PathParam;


@Path("leaveRequest")
public class Ressources { 

	    @GET
	    @Path("/getallempl")
	    @Produces("application/json")
	  
//	    @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
//	    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	    public List<Employee> getEmployee() {
	      EmployeeDAO dao = new EmployeeDAO();
	      List<Employee> employees = dao.getAllEmployees();
	        return employees;
	    }

	    @POST
	    @Path("/createEmpl")
	    @Consumes("application/json")
	    public Response addEmployee(Employee emp){
	    emp.setId(emp.getId());
	    emp.setFistName(emp.getFistName());
	    emp.setEmail(emp.getEmail());
	    emp.setGender(emp.getGender());
	    emp.setMobilenumber(emp.getMobilenumber());
	    emp.setPosition(emp.getPosition());
	    emp.setVacations(emp.getVacations());
	    emp.setAddress(emp.getAddress());
	    EmployeeDAO dao = new EmployeeDAO();
	    dao.saveEmployee(emp);
	    
	    return Response.ok("l'operation a reussite").build();
	    }
    
	    @GET
	    @Path("getEmpid/{id}")
	    @Produces("application/json")
	    public Employee getEmployeeById(@PathParam("id") int id) {
	    	EmployeeDAO dao = new EmployeeDAO();
	    	Employee employee = dao.getEmployeeById(id);
		      return employee;
		      

	    }
	    
	    @PUT
	    @Path("/updateempl/{id}")
	    @Consumes("application/json")
	    public Response updateEmployee(@PathParam("id") int id, Employee emp){
	      EmployeeDAO dao = new EmployeeDAO();
	    int count = dao.updateEmployee(id, emp);
	    if(count==0){
	      return Response.status(Response.Status.BAD_REQUEST).build();
	    }
	    return Response.ok("l'operation a reussite").build();
	    }
    
	    @DELETE
	    @Path("/deleteempl/{id}")
	    @Consumes(MediaType.APPLICATION_JSON)
	    public Response deleteEmployee(@PathParam("id") int id){
	      EmployeeDAO dao = new EmployeeDAO();
	    int count = dao.deleteEmployeeById(id);
	    if(count==0){
	      return Response.status(Response.Status.BAD_REQUEST).build();
	    }
	    return Response.ok("Rows affected: "+count).build();
	    }
	    
	
	    @GET()
	    @Path("getAllEtudiant")

	    @Produces("application/json")
	    public List<Etudiant> getEtudiant() {
		 EtudiantDAO dao = new EtudiantDAO();
	      List etudiants = dao.getAllEtudiants();
	        return etudiants;
	    }

	 
	    @GET
	    @Path("getEtudid/{id}")
	    @Produces("application/json")
	    public Etudiant getEtudiantById(@PathParam("id") int id) {
	    	EtudiantDAO dao = new EtudiantDAO();
	    	Etudiant etudiant = dao.getEtudiantById(id);
		      return etudiant;
		      

	    }
	 

	
	    @POST
	    @Path("/create")
	    @Consumes("application/json")
	    
	
	    public Response addEtudiant(Etudiant etud){
	    etud.setId(etud.getId());
	    etud.setName(etud.getName());
	    etud.setEmail(etud.getEmail());
	    etud.setPhone(etud.getPhone());
	            
	    EtudiantDAO dao = new EtudiantDAO();
	    dao.saveEtudiant(etud);
	    
	    return Response.ok("l'operation a reussite").build();
	    }
	    
	    @PUT
	    @Path("/update/{id}")
	    @Consumes("application/json")
	    public Response updateEtudiant(@PathParam("id") int id, Etudiant etud){
	    	EtudiantDAO dao = new EtudiantDAO();
	    int count = dao.updateEtudiant(id, etud);
	    if(count==0){
	      return Response.status(Response.Status.BAD_REQUEST).build();
	    }
	    return Response.ok("l'operation a reussite").build();
	    }
	    
	    
	    @DELETE
	    @Path("/delete/{id}")
	    @Consumes(MediaType.APPLICATION_JSON)
	    public Response deleteEtudiant(@PathParam("id") int id){
	    	EtudiantDAO dao = new EtudiantDAO();
	    int count = dao.deleteEtudiantById(id);
	    if(count==0){
	      return Response.status(Response.Status.BAD_REQUEST).build();
	    }
	    return Response.ok("Rows affected: "+count).build();
	    }
	
}
