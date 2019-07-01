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

import com.beginner.inheritance.config.HibernateConfiguration;
import com.beginner.inheritance.entity.BankAccount;
import com.beginner.inheritance.entity.CreditAccount;
import com.beginner.inheritance.entity.DebitAccount;

public class HibernateApp {
	

	
	public static void main(String[] args) {
		
				
		//create session or use session!
		Session session = HibernateConfiguration.retrieveSessionFactory().openSession();
		Transaction transaction = null;
		
		try {
			
			
			  transaction = session.beginTransaction(); CreditAccount creditAccount = new
			  CreditAccount(); creditAccount.setAccountHolderName("OD");
			  creditAccount.setBalance(4444.8888);
			  creditAccount.setCreditLimit(4444444444.8);
			  creditAccount.setInteresteRate(4.0);
			  
			  session.save(creditAccount); transaction.commit();
			 
			
			
			  transaction = null; 
			  transaction = session.beginTransaction(); 
			  DebitAccount debitAccount = new DebitAccount(); 
			  debitAccount.setAccountHolderName("BNP");
			  debitAccount.setBalance(18.88); 
			  debitAccount.setInteresteRate(2.8);
			  debitAccount.setOverDraftLimit(544441.88);
			  
			  session.save(debitAccount); 
			  transaction.commit();
			 
			
			
		} catch (HibernateException e) {
			// TODO: handle exception
			transaction.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		
			
		}
		
		
		
		
		
		
		
	}

}
