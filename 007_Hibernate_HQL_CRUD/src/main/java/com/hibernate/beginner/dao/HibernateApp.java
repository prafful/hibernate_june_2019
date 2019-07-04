package com.hibernate.beginner.dao;


import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.hibernate.beginner.entity.Friend;
import com.hibernate.beginner.entity.InsertFriendTemp;
import com.hibernate.beginner.utility.HibernateUtility;


public class HibernateApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Transaction transaction = null;
		Session session = null;
		try {
			session = HibernateUtility.retrieveSessionFactory().openSession();
		
			
			//delete all rows from temp_friend (mapped by InsertFriendTemp) before the actual insert in friend table happens!
			transaction = session.beginTransaction();
			String hql = "delete from InsertFriendTemp";
			Query query = session.createQuery(hql);
			int i = query.executeUpdate();
			System.out.println("Count of rows deleted from temp friend table: " + i);
			transaction.commit();
			
			//insert query
			InsertFriendTemp f_temp = new InsertFriendTemp();
			f_temp.setName("OBB");
			f_temp.setLocation("Chennai");
			
			transaction = session.beginTransaction();
			//insert into temp_table before inserting in friend table!
			session.save(f_temp);
			//int i = query.executeUpdate();
			transaction.commit();
			
			
			//get values from temp_table and then insert into friend table
			transaction=session.beginTransaction();
			hql = "insert into Friend (name, location) select name, location from InsertFriendTemp";
			query = session.createQuery(hql);
			i = query.executeUpdate();
			System.out.println("Insert into friend using HQL : rows updated: " + i);
			transaction.commit();
			
			//retrieve friend with some id!
			transaction = null;
			transaction = session.beginTransaction();
			hql = "from Friend F where F.id = :friendId";
			query = session.createQuery(hql);
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
			query.setParameter("friendId", 10L);
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
