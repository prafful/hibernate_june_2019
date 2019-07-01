package com.beginner.inheritance.entity;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity (name = "Bank_Account_Joined_Table")
@Inheritance(strategy = InheritanceType.JOINED )
public class BankAccount {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY )
	private Long id;
	@Column
	private String accountHolderName;
	@Column
	private Double balance;
	@Column
	private Double interesteRate;

}
