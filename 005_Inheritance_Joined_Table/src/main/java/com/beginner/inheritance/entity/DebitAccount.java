package com.beginner.inheritance.entity;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity (name="debit_account")
@PrimaryKeyJoinColumn(name = "bankaccount_id")
public class DebitAccount extends BankAccount{
	
	private Double overDraftLimit;

}
