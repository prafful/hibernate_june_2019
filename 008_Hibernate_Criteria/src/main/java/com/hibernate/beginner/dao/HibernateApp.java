package com.hibernate.beginner.dao;


import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import com.hibernate.beginner.entity.Friend;
import com.hibernate.beginner.utility.HibernateUtility;


public class HibernateApp {

	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Transaction transaction = null;
		Session session = null;
		try {
			session = HibernateUtility.retrieveSessionFactory().openSession();
			transaction = session.beginTransaction();
			
			
			//get all friends
			Criteria criteria = session.createCriteria(Friend.class);
			List<Friend> friends = criteria.list();
			for(Friend f: friends) {
				System.out.println("Id: " + f.getId() + " Name: " + f.getName() + " from " + f.getLocation());
			}
			
			
			//get friend with some id using criteria and restrictions!
			criteria  = session.createCriteria(Friend.class);
			Long findId = 1L;
			criteria.add(Restrictions.eq("id", findId));
			Friend f = (Friend) criteria.uniqueResult();
			if(f != null) {
				System.out.println("Id: " + f.getId() + " Name: " + f.getName() + " from " + f.getLocation());
			}else {
				System.out.println("Friend with id: " + findId + " not found!!!!") ;
			}
			
			
			//Pagination
			criteria  = session.createCriteria(Friend.class);
			criteria.addOrder(Order.asc("id"));
			criteria.setFirstResult(0);
			criteria.setMaxResults(3);
			friends = criteria.list();
			for(Friend f1: friends) {
				System.out.println("Id: " + f1.getId() + " Name: " + f1.getName() + " from " + f1.getLocation());
			}
			
			criteria.addOrder(Order.asc("id"));
			criteria.setFirstResult(3);
			criteria.setMaxResults(3);
			friends = criteria.list();
			for(Friend f1: friends) {
				System.out.println("Id: " + f1.getId() + " Name: " + f1.getName() + " from " + f1.getLocation());
			}
			
			//like query
			criteria = session.createCriteria(Friend.class);
			criteria.add(Restrictions.like("name", "%oy%"));
			friends = criteria.list();
			for(Friend f2: friends) {
				System.out.println("Id: " + f2.getId() + " Name: " + f2.getName() + " from " + f2.getLocation());
			}
			
			//projections - can be used for single column query OR Query which we want to run on single column!! or for aggregate functions (min, max)!
			criteria = session.createCriteria(Friend.class);
			criteria.setProjection(Projections.rowCount());
			criteria.add(Restrictions.like("name","%a%"));
			Long count = (Long) criteria.uniqueResult();
			System.out.println("Count of rows: " + count);
			
			
			
			
		} catch (Exception e) {
			// TODO: handle exception
			
			e.printStackTrace();
		}  finally {
			session.close();
			
		}
		

	}

}
