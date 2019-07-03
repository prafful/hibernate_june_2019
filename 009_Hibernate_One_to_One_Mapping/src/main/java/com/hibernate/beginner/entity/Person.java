package com.hibernate.beginner.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table (name = "person_india")
public class Person {
	
	@Id
	@Column(name="person_id")
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private int person_id;
	
	@Column (name = "first_name")
	private String firstname;
	
	@Column (name = "last_name")
	private String lastName;
	
	@OneToOne
	@JoinColumn(name = "pan_card_id")
	private PAN panDetail;

}
