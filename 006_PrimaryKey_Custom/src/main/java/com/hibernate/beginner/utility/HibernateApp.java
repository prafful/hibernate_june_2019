package com.hibernate.beginner.utility;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.hibernate.beginner.entity.Friend;

public class HibernateApp {
	
	public static void main(String[] args) {
		Configuration configuration = new Configuration();
		configuration.addResource("friend.hbm.xml");
		configuration.configure("hibernate.cfg.xml");
		SessionFactory sessionFactory = configuration.buildSessionFactory();
		Session session = sessionFactory.openSession();
		
		for(int i=0;i<10;i++) {
			Transaction transaction = session.beginTransaction();
			Friend friend = new Friend();
			friend.setName("Oho"+i);
			friend.setLocation("Omaya"+i);
			session.save(friend);
			transaction.commit();
		}
		
		session.close();
		sessionFactory.close();
		}

}
