package com.api.dao;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.api.entity.Etudiant;
import com.api.entity.Vacations;

public class VocationImp implements DaoVocations {
private SessionFactory factory = SessionUtil.getFactory();
	
	@SuppressWarnings("deprecation")

	@Override
	public void saveVacations(Vacations Vacations) {
		Transaction transaction = null;
		try(Session session = factory.openSession()) {
			transaction = session.beginTransaction();
			session.save(Vacations);
			transaction.commit();
		} catch (Exception e) {
			if(transaction != null)
				transaction.rollback();
		}

	}

	@Override
	public Vacations getVacationsById(int id) {
		Transaction transaction = null;
		Vacations Vacations = null;
		try(Session session = factory.openSession()) {
			transaction = session.beginTransaction();
			Vacations = session.get(Vacations.class, id);
			System.out.println(Vacations);
			transaction.commit();
		} catch (Exception e) {
			if(transaction != null)
				transaction.rollback();
		}
		return Vacations;
	}

	@Override
	@SuppressWarnings({ "unchecked", "deprecation" })
	public List<Vacations> getAllVacations() {
		Transaction transaction = null;
		List<Vacations> Vacations = null;
		try(Session session = factory.openSession()) {
			transaction = session.beginTransaction();
			Vacations = session.createNativeQuery("Select * from Vacations",Vacations.class).list();
			transaction.commit();
		} catch (Exception e) {
			if(transaction != null)
				transaction.rollback();
		}
		return Vacations;
	}

	@Override
	public int updateVacations(int id, Vacations vcns) {
		  if(id <=0)  
		         return 0;  
		     Session session = factory.openSession();
		      Transaction tx = session.beginTransaction();
		      String hql = "update  Vacations set startDate = :date1,endDate=:date2,reason=:raiso,where id = :id";
		      Query query = session.createQuery(hql);
		      query.setParameter("id",id);
		      query.setParameter("date1",vcns.getStartDate());
		      query.setParameter("date2",vcns.getEndDate());
		      query.setParameter("raiso",vcns.getReason());
//		      employee
		      int rowCount = query.executeUpdate();
		      System.out.println("Rows affected: " + rowCount);
		      tx.commit();
		      session.close();
		      return rowCount;
	}

	@Override
	public int deleteVacationsById(int id) {
		  Session session = factory.openSession();
		    Transaction tx = session.beginTransaction();
		    String hql = "delete from Vacations where id = :id";
		    Query query = session.createQuery(hql);
		    query.setParameter("id",id);
		    int rowCount = query.executeUpdate();
		    System.out.println("Rows affected: " + rowCount);
		    tx.commit();
		    session.close();
		    return rowCount;
	}

}
