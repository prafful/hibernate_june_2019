package com.hibernate.beginner;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

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
		
		HibernateApp app = new HibernateApp();
		int primaryKey = app.insertFriend("Yuko", "Yokohama", "yuko@gmail.com");
		System.out.println("Friend created: " + primaryKey);
		
		
		//get list of friends from the database
		session = sessionFactory.openSession();
		transaction = null;
		List<Friend> friends = new ArrayList<Friend>();
		try {
			transaction = session.beginTransaction();
			friends =session.createQuery("from Friend").list();
			transaction.commit();
			
		} catch (HibernateException e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			session.close();
			
		}
		
		System.out.println("***************Get list of friends**************");
		for (Friend f : friends) {
			System.out.println("Id: " + f.getId());
			System.out.println("Name: " + f.getName());
			System.out.println("Location: " + f.getLocation());
			System.out.println("---------------------------");
		}
		
		
		//delete one friend
		session = sessionFactory.openSession();
		transaction = null;
		
		try {
			Object friendObject = session.load(Friend.class, new Integer(5));
			Friend f = (Friend) friendObject;
			transaction = session.beginTransaction();
			session.delete(f);
			transaction.commit();
			System.out.println("Friend with ID: " + f.getId() + " deleted!");
		} catch (HibernateException e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			session.close();	
		}
		
		//update friend
		session = sessionFactory.openSession();
		transaction = null;
		
		try {
			Object friendObject = session.load(Friend.class, new Integer(9));
			Friend f = (Friend) friendObject;
			transaction = session.beginTransaction();
			//update the values in friend instance with setters
			f.setName("Pokemon");
			f.setEmail("pokemon@gmail.com");
			session.update(f);
			transaction.commit();
			System.out.println("Friend with ID: " + f.getId() + " updated!");
		} catch (HibernateException e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			session.close();	
		}
		
		
		
				
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
