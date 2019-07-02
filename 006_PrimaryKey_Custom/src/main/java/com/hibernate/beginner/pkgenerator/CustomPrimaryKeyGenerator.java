package com.hibernate.beginner.pkgenerator;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Random;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

public class CustomPrimaryKeyGenerator implements IdentifierGenerator{
	
	
	public int generateRandomNumber() {
		Random randomNumber  = new Random();
		return randomNumber.nextInt(100);
	}
	
	

	public Serializable generate(SharedSessionContractImplementor session, Object object) throws HibernateException {
		// TODO Auto-generated method stub
	 //Date date = new Date();
	 Calendar calendar = Calendar.getInstance();
	 return "Friend_"+this.generateRandomNumber() + "_"+calendar.get(Calendar.MILLISECOND)+"_"+calendar.get(Calendar.YEAR);
	 
	}

}
