package com.beginner.inheritance.entity;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity (name="debit_account")
@DiscriminatorValue(value = "debit")
public class DebitAccount extends BankAccount{
	
	private Double overDraftLimit;

}
