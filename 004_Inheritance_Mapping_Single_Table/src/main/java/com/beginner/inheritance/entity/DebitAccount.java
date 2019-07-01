package com.beginner.inheritance.entity;

import javax.persistence.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity (name="debit_account")
public class DebitAccount extends BankAccount{
	
	private Double overDraftLimit;

}
