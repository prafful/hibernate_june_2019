package com.hibernate.inheritance.entity;

import javax.persistence.Entity;

import lombok.Data;

@Data
@Entity (name = "debit_account")
public class DebitAccount extends BankAccount{

	private Double overdraftLimit;
}
