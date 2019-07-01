package com.beginner.inheritance.app;

import java.util.Properties;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

import com.beginner.inheritance.entity.BankAccount;
import com.beginner.inheritance.entity.CreditAccount;
import com.beginner.inheritance.entity.DebitAccount;

public class HibernateApp {
	
	private static SessionFactory sessionFactory;
	private static ServiceRegistry serviceRegistry;
	
	public static void main(String[] args) {
		
		//allows us to define all configuarion required for database connectivity
		Configuration configuration = new Configuration();
		//configuration.configure();
		//java based configuration - replacing hibernate.cfg.xml
		Properties properties = new Properties();
		properties.put(Environment.DRIVER, "com.mysql.jdbc.Driver");
		properties.put(Environment.URL, "jdbc:mysql://localhost:3306/hibernate_inheritance_singletable");
		properties.put(Environment.USER, "root");
		properties.put(Environment.PASS, "root1");
		properties.put(Environment.DIALECT, "org.hibernate.dialect.MySQL5Dialect");
		properties.put(Environment.HBM2DDL_AUTO, "create");
		properties.put(Environment.SHOW_SQL, true);
		
		
		//use properties to set configuration
		configuration.setProperties(properties);
		
		//add entities to the configuration
		configuration.addAnnotatedClass(BankAccount.class);
		configuration.addAnnotatedClass(CreditAccount.class);
		configuration.addAnnotatedClass(DebitAccount.class);
		
		//use configuration (populated with all properties and entities) to create serrviceRegistry
		
		serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
		
		sessionFactory = configuration.buildSessionFactory(serviceRegistry);
		
		//create session or use session!
		Session session = sessionFactory.openSession();
		Transaction transaction = null;
		
		try {
			
			transaction = session.beginTransaction();
			CreditAccount creditAccount = new CreditAccount();
			creditAccount.setAccountHolderName("Prafful Daga");
			creditAccount.setBalance(8888.8888);
			creditAccount.setCreditLimit(88888888.8);
			creditAccount.setInteresteRate(8.0);
			
			session.save(creditAccount);
			transaction.commit();
			
			transaction = null;
			transaction = session.beginTransaction();		
			DebitAccount debitAccount = new DebitAccount();
			debitAccount.setAccountHolderName("OBB");
			debitAccount.setBalance(88.88);
			debitAccount.setInteresteRate(8.8);
			debitAccount.setOverDraftLimit(88888.88);
			
			session.save(debitAccount);
			transaction.commit();
			
			
		} catch (HibernateException e) {
			// TODO: handle exception
			transaction.rollback();
			e.printStackTrace();
		} finally {
			session.close();
			sessionFactory.close();
			
		}
		
		
		
		
		
		
		
	}

}
