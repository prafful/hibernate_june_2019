package com.hibernate.inheritance.entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@MappedSuperclass
//@Entity
//@Inheritance (strategy = InheritanceType.SINGLE_TABLE)
//@Table(name="bankaccount_single_table")
public class BankAccount {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String acccountHolder;
	private Double balance;
	private Double interestRate;
 
}
