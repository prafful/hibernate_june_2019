package com.hibernate.beginner.dao;


import org.hibernate.Session;
import org.hibernate.Transaction;

import com.hibernate.beginner.entity.Course;
import com.hibernate.beginner.entity.Student;
import com.hibernate.beginner.utility.HibernateUtility;


public class HibernateApp {

	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Transaction transaction = null;
		Session session = null;
		try {
			session = HibernateUtility.retrieveSessionFactory().openSession();
		
			Course course1 = new Course();
			course1.setName("Hibernate");
			course1.setDuration(24);
			
			Course course2 = new Course();
			course2.setName("Angular");
			course2.setDuration(32);
			
			Course course3 = new Course();
			course3.setName("Microservices");
			course3.setDuration(16);
			
			Student student1 = new Student();
			student1.setName("PD");
			student1.setScore(88);
			student1.getCourses().add(course1);
			student1.getCourses().add(course2);
			
			Student student2 = new Student();
			student2.setName("AD");
			student2.setScore(99);
			student2.getCourses().add(course2);
			student2.getCourses().add(course3);
			
			transaction = session.beginTransaction();
			session.save(course1);
			session.save(course2);
			session.save(course3);
			session.save(student1);
			session.save(student2);
			
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
