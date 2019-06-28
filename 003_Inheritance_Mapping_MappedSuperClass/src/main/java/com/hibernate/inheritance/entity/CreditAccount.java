package com.hibernate.inheritance.entity;

import javax.persistence.Entity;

import lombok.Data;

@Data
@Entity(name = "credit_account")
public class CreditAccount extends BankAccount {
	
	private Double creditLimit;

}
