package com.beginner.inheritance.config;

import java.util.Properties;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

import com.beginner.inheritance.entity.BankAccount;
import com.beginner.inheritance.entity.CreditAccount;
import com.beginner.inheritance.entity.DebitAccount;

public class HibernateConfiguration {
	
	private static SessionFactory sessionFactory;
	private static ServiceRegistry serviceRegistry;
	
	public static SessionFactory retrieveSessionFactory() {
		
		if(sessionFactory == null) {
			
			try {
				//allows us to define all configuration required for database connectivity
				Configuration configuration = new Configuration();
				//configuration.configure();
				//java based configuration - replacing hibernate.cfg.xml
				Properties properties = new Properties();
				properties.put(Environment.DRIVER, "com.mysql.jdbc.Driver");
				properties.put(Environment.URL, "jdbc:mysql://localhost:3306/hibernate_inheritance_joinedtable");
				properties.put(Environment.USER, "root");
				properties.put(Environment.PASS, "root1");
				properties.put(Environment.DIALECT, "org.hibernate.dialect.MySQL5Dialect");
				properties.put(Environment.HBM2DDL_AUTO, "update");
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
				
			} catch (HibernateException e) {
				e.printStackTrace();
				if(serviceRegistry != null) {
					StandardServiceRegistryBuilder.destroy(serviceRegistry);
				}
				// TODO: handle exception
			}
				
		}
				return sessionFactory;
		
		
	}
	

}
