package com.api.dao;

import java.util.ArrayList;
import java.util.List;
import org.hibernate.SessionFactory;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cache.CacheException;

import com.api.entity.Employee;
import com.api.entity.Etudiant;


import jakarta.inject.Inject;

public class EmployeeDAO implements Dao{
	
	
private SessionFactory factory = SessionUtil.getFactory();
	
	@SuppressWarnings("deprecation")
	@Override
	public void saveEmployee(Employee Employee) {
		Transaction transaction = null;
		try(Session session = factory.openSession()) {
			transaction = session.beginTransaction();
		
			session.save(Employee);
			
			transaction.commit();
		
		} catch (Exception e) {
			if(transaction != null)
				transaction.rollback();
		}
	}
	
	@Override
	public Employee getEmployeeById(int id) {
		Transaction transaction = null;
		Employee Employee = null;
		try(Session session = factory.openSession()) {
			transaction = session.beginTransaction();
			Employee = session.get(Employee.class, id);
			transaction.commit();
		} catch (Exception e) {
			if(transaction != null)
				transaction.rollback();
		}
		return Employee;
	}
	

	
	
	
	@Override
	@SuppressWarnings({ "unchecked", "deprecation" })
	public List<Employee> getAllEmployees() {
//		Transaction transaction = null;
//		List<Employee> Employees = null;
//		try(Session session = ) {
//			transaction = session.beginTransaction();
//			Employees = session.createNativeQuery("Select * from Employee",Employee.class).list();
//			transaction.commit();
//		} catch (Exception e) {
//			if(transaction != null)
//				transaction.rollback();
//		}
//		return Employees;
//	}
	List<Employee> list = new ArrayList<Employee>();
    Session session = factory.openSession();
    Transaction tx = null;
    try{
        tx = session.beginTransaction();
        Query q = session.createQuery("From Employee");
        List<Employee> l = q.list();
        for (Employee e : l){
            list.add(e);
        }
    }catch(CacheException e){
        if(tx != null) tx.rollback();
        e.printStackTrace();
    }
    finally{
        session.close();
    }
    return list;}

	
	public int updateEmployee(int id, Employee emp){
	     if(id <=0)  
	         return 0;  
	     Session session = factory.openSession();
	      Transaction tx = session.beginTransaction();
	      String hql = "update Employee set Name = :name, age=:email,address=:adress,position=:position,"
	      		+ " mobilenumber=:phone, mobilenumber=:phone,vacations=:vocation  where id = :id";
	      Query query = session.createQuery(hql);
	      query.setParameter("id",id);
	      query.setParameter("name",emp.getFistName());
	      query.setParameter("email",emp.getEmail());
	      query.setParameter("adress",emp.getAddress());
	      query.setParameter("position",emp.getPosition());
	      query.setParameter("phone",emp.getMobilenumber());
	      query.setParameter("gender",emp.getGender());
	      query.setParameter("vocation",emp.getVacations());
	      
	      int rowCount = query.executeUpdate();
	      System.out.println("Rows affected: " + rowCount);
	      tx.commit();
	      session.close();
	      return rowCount;
	  }
	


	@Override
	  public int deleteEmployeeById(int id) {
	    Session session = factory.openSession();
	    Transaction tx = session.beginTransaction();
	    String hql = "delete from Employee where id = :id";
	    Query query = session.createQuery(hql);
	    query.setParameter("id",id);
	    int rowCount = query.executeUpdate();
	    System.out.println("Rows affected: " + rowCount);
	    tx.commit();
	    session.close();
	    return rowCount;
	  }

	

}
