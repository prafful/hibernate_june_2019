package com.hibernate.beginner.dao;


import org.hibernate.Session;
import org.hibernate.Transaction;

import com.hibernate.beginner.entity.Office;
import com.hibernate.beginner.entity.People;
import com.hibernate.beginner.utility.HibernateUtility;


public class HibernateApp {

	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Transaction transaction = null;
		Session session = null;
		try {
			session = HibernateUtility.retrieveSessionFactory().openSession();
		
			People people1 = new People();
			people1.setName("Ori");
			
			People people2 = new People();
			people2.setName("Mori");
			
			
			People people3 = new People();
			people3.setName("Kita");
			
			People people4 = new People();
			people4.setName("Mita");
			
			Office office1 = new Office();
			office1.setCity("Chennai");

			Office office2 = new Office();
			office2.setCity("Kochi");
			
			
			people1.setOffice(office1);
			people2.setOffice(office1);
			
			people3.setOffice(office2);
			people4.setOffice(office2);
			
			transaction = session.beginTransaction();
			
			session.save(people1);
			session.save(people2);
			session.save(people3);
			session.save(people4);
			session.save(office1);
			session.save(office2);
			
						
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
