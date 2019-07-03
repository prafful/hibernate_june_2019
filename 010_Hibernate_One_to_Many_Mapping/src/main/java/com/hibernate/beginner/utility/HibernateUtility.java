package com.hibernate.beginner.utility;

import java.util.Properties;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

import com.hibernate.beginner.entity.Address;
import com.hibernate.beginner.entity.User;

public class HibernateUtility {
	
	private static SessionFactory sessionFactory;
	private static ServiceRegistry serviceRegistry;
	
	public static SessionFactory retrieveSessionFactory() {
		if(sessionFactory == null) {
			
			try {
				//allows us to define all configuarion required for database connectivity
				Configuration configuration = new Configuration();
				//configuration.configure();
				//java based configuration - replacing hibernate.cfg.xml
				Properties properties = new Properties();
				properties.put(Environment.DRIVER, "com.mysql.jdbc.Driver");
				properties.put(Environment.URL, "jdbc:mysql://localhost:3306/hibernate2019_one_to_many");
				properties.put(Environment.USER, "root");
				properties.put(Environment.PASS, "root1");
				properties.put(Environment.DIALECT, "org.hibernate.dialect.MySQL5Dialect");
				properties.put(Environment.HBM2DDL_AUTO, "update");
				properties.put(Environment.SHOW_SQL, true);
				
				
				//use properties to set configuration
				configuration.setProperties(properties);
				
				// add an entity to configuration 
				//configuration.addAnnotatedClass(Friend.class);
				configuration.addAnnotatedClass(User.class);
				configuration.addAnnotatedClass(Address.class);
				
				//use configuration (populated with all properties and entities) to create serrviceRegistry
				
				serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
						
				sessionFactory = configuration.buildSessionFactory(serviceRegistry);
			} catch (HibernateException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		
						
		}
		
		return sessionFactory;

	}

}
