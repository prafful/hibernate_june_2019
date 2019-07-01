package com.hibernate.inheritance.app;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import com.hibernate.inheritance.entity.BankAccount;
import com.hibernate.inheritance.entity.CreditAccount;
import com.hibernate.inheritance.entity.DebitAccount;

public class HibernateApp {
	
	private static SessionFactory sessionFactory;
	private static ServiceRegistry serviceRegistry;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Configuration configuration = new Configuration();
		configuration.configure();
		
		configuration.addAnnotatedClass(BankAccount.class);
		configuration.addAnnotatedClass(CreditAccount.class);
		configuration.addAnnotatedClass(DebitAccount.class);
		
		serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
		
		sessionFactory = configuration.buildSessionFactory(serviceRegistry);
		
		
		  CreditAccount creditAccount = new CreditAccount();
		  creditAccount.setAcccountHolder("PD");
		  creditAccount.setBalance(8888.8888); creditAccount.setInterestRate(8.8);
		  creditAccount.setCreditLimit(88888888.8);
		 
		/*
		 * DebitAccount debitAccount = new DebitAccount();
		 * debitAccount.setAcccountHolder("AD"); debitAccount.setBalance(8888.8888);
		 * debitAccount.setInterestRate(8.8);
		 * debitAccount.setOverdraftLimit(88888888.8);
		 */
		
		Session session = sessionFactory.openSession();
		Transaction transaction = null;
		transaction = session.beginTransaction();
		session.save(creditAccount);
		//session.save(debitAccount);
		transaction.commit();
		//System.out.println("Commited a debit account transaction!");
		System.out.println("Commited a credit account transaction!");
		
		session.close();
		sessionFactory.close();
		
		
	}

}
