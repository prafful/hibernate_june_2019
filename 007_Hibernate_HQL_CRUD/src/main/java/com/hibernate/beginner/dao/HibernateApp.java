package com.hibernate.beginner.dao;


import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.hibernate.beginner.entity.Friend;
import com.hibernate.beginner.utility.HibernateUtility;


public class HibernateApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Transaction transaction = null;
		Session session = null;
		try {
			session = HibernateUtility.retrieveSessionFactory().openSession();
			//transaction = session.beginTransaction();
			
			//insert query
			Friend f = new Friend();
			f.setName("Okie");
			f.setLocation("Omo");
			//String hql = "insert into Friend (name, location) select name, location from Friend";
			//Query query = session.createQuery(hql);
			
			transaction = session.beginTransaction();
			session.save(f);
			//int i = query.executeUpdate();
			transaction.commit();
			//System.out.println("No of rows updated: " + i);
			
			
			//retrieve friend with some id!
			transaction = null;
			transaction = session.beginTransaction();
			String hql = "from Friend F where F.id = :friendId";
			Query query = session.createQuery(hql);
			query.setParameter("friendId", 3L);
			List results  = query.getResultList();
			
			if(results != null && !results.isEmpty()) {
				Friend getF = (Friend) results.get(0);
				System.out.println(getF.getId() + ". " + getF.getName() + " " + getF.getLocation());
			}
			
			transaction.commit();
			
			
			//delete friend with id
			transaction = null;
			transaction = session.beginTransaction();
		    hql = "delete from Friend F where F.id = :friendId";
			query = session.createQuery(hql);
			query.setParameter("friendId", 6L);
			int deletedRowCount = query.executeUpdate();
			System.out.println("Number of rows deleted: " + deletedRowCount);
			transaction.commit();
			
			//update friend with some id
			transaction = null;
			transaction = session.beginTransaction();
		    hql = "update Friend F set name = :newName where  id = :findThisId";
			query = session.createQuery(hql);
			query.setParameter("findThisId", 7L);
			query.setParameter("newName", "Oyo");
			int updatedRowCount = query.executeUpdate();
			System.out.println("Number of rows updated: " + updatedRowCount);
			transaction.commit();
			
			
			
			
		} catch (Exception e) {
			// TODO: handle exception
			transaction.rollback();
			e.printStackTrace();
		}  finally {
			session.close();
			System.out.println(transaction.isActive());
		}
		

	}

}
