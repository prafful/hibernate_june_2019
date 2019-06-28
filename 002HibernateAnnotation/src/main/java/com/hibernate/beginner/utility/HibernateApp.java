package com.hibernate.beginner.utility;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import com.hibernate.beginner.entity.Friend;

public class HibernateApp {

	private static SessionFactory sessionFactory;
	private static ServiceRegistry serviceRegistry;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//create configuration object. It is a first object!
		Configuration configuration = new Configuration();
		configuration.configure();
		//add mapping information to configuration object
		configuration.addAnnotatedClass(Friend.class);
		//configuration.addResource("Friend.hbm.xml");
		System.out.println("********************************************************");
		System.out.println(configuration.getProperties());
		System.out.println("********************************************************");
		//use above configuration to create contract - called - serviceRegistry
		serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
		//use service registry to create session factory
		sessionFactory = configuration.buildSessionFactory(serviceRegistry);
		
		HibernateApp app = new HibernateApp();
		int primaryKey = app.insertFriend("Shiva", "Kailash", "shiva@gmail.com");
		System.out.println("Friend created: " + primaryKey);
		
		

	}

	
private int insertFriend(String name, String location, String email) {
		
		//insert implemetation
		//the beginning and end of a logical transaction
		Session session = sessionFactory.openSession();
		Transaction transaction = null;
		Integer id = null;
		
		try {
			transaction = session.beginTransaction();
			Friend friend = new Friend();
			friend.setName(name);
			friend.setLocation(location);
			friend.setEmail(email);
			id = (Integer) session.save(friend);
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
		return id;
	}
}
