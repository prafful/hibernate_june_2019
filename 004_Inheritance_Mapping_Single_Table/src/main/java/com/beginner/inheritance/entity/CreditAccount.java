package com.beginner.inheritance.entity;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity (name="credit_account")
@DiscriminatorValue(value = "credit")
public class CreditAccount extends BankAccount {
	
	private Double creditLimit;

}
