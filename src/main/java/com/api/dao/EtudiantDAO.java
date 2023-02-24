package com.api.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.api.entity.Etudiant;


public class EtudiantDAO implements DaoEtud{

private SessionFactory factory = SessionUtil.getFactory();
	
	@SuppressWarnings("deprecation")
	@Override
	public void saveEtudiant(Etudiant Etudiant) {
		Transaction transaction = null;
		try(Session session = factory.openSession()) {
			transaction = session.beginTransaction();
			session.save(Etudiant);
			transaction.commit();
		} catch (Exception e) {
			if(transaction != null)
				transaction.rollback();
		}
	}
	
	@Override
	public Etudiant getEtudiantById(int id) {
		Transaction transaction = null;
		Etudiant Etudiant = null;
		try(Session session = factory.openSession()) {
			transaction = session.beginTransaction();
			Etudiant = session.get(Etudiant.class, id);
			System.out.println(Etudiant);
			transaction.commit();
		} catch (Exception e) {
			if(transaction != null)
				transaction.rollback();
		}
		return Etudiant;
	}
	
	
	@Override
	@SuppressWarnings({ "unchecked", "deprecation" })
	public List<Etudiant> getAllEtudiants() {
		Transaction transaction = null;
		List<Etudiant> Etudiants = null;
		try(Session session = factory.openSession()) {
			transaction = session.beginTransaction();
			Etudiants = session.createNativeQuery("Select * from Etudiant",Etudiant.class).list();
			transaction.commit();
		} catch (Exception e) {
			if(transaction != null)
				transaction.rollback();
		}
		return Etudiants;
	}
	

	
	public int updateEtudiant(int id, Etudiant etud){
	     if(id <=0)  
	         return 0;  
	     Session session = factory.openSession();
	      Transaction tx = session.beginTransaction();
	      String hql = "update Etudiant set name = :name, age=:age where id = :id";
	      Query query = session.createQuery(hql);
	      query.setParameter("id",id);
	      query.setParameter("name",etud.getName());
	      query.setParameter("email",etud.getEmail());
	      query.setParameter("phone",etud.getPhone());
	      int rowCount = query.executeUpdate();
	      System.out.println("Rows affected: " + rowCount);
	      tx.commit();
	      session.close();
	      return rowCount;
	  }
	


	@Override
	  public int deleteEtudiantById(int id) {
	    Session session = factory.openSession();
	    Transaction tx = session.beginTransaction();
	    String hql = "delete from Etudiant where id = :id";
	    Query query = session.createQuery(hql);
	    query.setParameter("id",id);
	    int rowCount = query.executeUpdate();
	    System.out.println("Rows affected: " + rowCount);
	    tx.commit();
	    session.close();
	    return rowCount;
	  }

}
