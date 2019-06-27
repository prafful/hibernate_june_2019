package com.hibernate.beginner;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import com.mysql.cj.jdbc.SuspendableXAConnection;

public class HibernateApp {
	
	private static SessionFactory sessionFactory;
	private static ServiceRegistry serviceRegistry;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//create configuration object. It is a first object!
		Configuration configuration = new Configuration();
		configuration.configure();
		//add mapping information to configuration object
		configuration.addResource("Friend.hbm.xml");
		System.out.println("********************************************************");
		System.out.println(configuration.getProperties());
		System.out.println("********************************************************");
		//use above configuration to create contract - called - serviceRegistry
		serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
		//use service registry to create session factory
		sessionFactory = configuration.buildSessionFactory(serviceRegistry);
		
		//insert implemetation
		//the beginning and end of a logical transaction
		Session session = sessionFactory.openSession();
		Transaction transaction = null;
		
		try {
			transaction = session.beginTransaction();
			Friend friend = new Friend();
			friend.setName("Prafful");
			friend.setLocation("Japan");
			friend.setEmail("prraful@gmail.com");
			Integer id = (Integer) session.save(friend);
			System.out.println("Identifier Value: " +  id);
			transaction.commit();
			
		} catch (HibernateException e) {
			// TODO: handle exception
			if(transaction != null) {
				System.out.println("**********Rolling Back*************");
				transaction.rollback();
				e.printStackTrace();
			}
		} finally {
			session.close();	
		}
		
		
		
	
		
		
		
		
		
		
	}

}
