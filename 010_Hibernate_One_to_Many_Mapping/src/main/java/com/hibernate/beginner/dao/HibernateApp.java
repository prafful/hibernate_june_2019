package com.hibernate.beginner.dao;


import org.hibernate.Session;
import org.hibernate.Transaction;

import com.hibernate.beginner.entity.Address;
import com.hibernate.beginner.entity.User;
import com.hibernate.beginner.utility.HibernateUtility;


public class HibernateApp {

	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Transaction transaction = null;
		Session session = null;
		try {
			session = HibernateUtility.retrieveSessionFactory().openSession();
		
			Address address1 = new Address();
			address1.setStreet("Street 1");
			address1.setCity("City 1");
			
			Address address11 = new Address();
			address11.setStreet("Street 11");
			address11.setCity("City 11");
			
			User user = new User();
			user.setUsername("username1");
			user.getAddress().add(address1);
			user.getAddress().add(address11);
			
			transaction =session.beginTransaction();
			session.save(address1);
			session.save(address11);
			session.save(user);
						
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
