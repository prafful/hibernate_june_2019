package com.hibernate.beginner.dao;


import org.hibernate.Session;
import org.hibernate.Transaction;

import com.hibernate.beginner.entity.PAN;
import com.hibernate.beginner.entity.Person;
import com.hibernate.beginner.utility.HibernateUtility;


public class HibernateApp {

	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Transaction transaction = null;
		Session session = null;
		try {
			session = HibernateUtility.retrieveSessionFactory().openSession();
		
			Person person = new Person();
			PAN pan = new PAN();
			
			person.setFirstname("Prafful");
			person.setLastName("Daga");
			pan.setPanNumber("AAAAA8888A");
			person.setPanDetail(pan);
			
			transaction = session.beginTransaction();
			session.save(person);
			session.save(pan);
			
			transaction.commit();
			
			
			
			
		} catch (Exception e) {
			// TODO: handle exception
			transaction.rollback();
			e.printStackTrace();
		}  finally {
			session.close();
			
		}
		

	}

}
