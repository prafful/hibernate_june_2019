package com.hibernate.beginner.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "office_people")
public class People {

	@Id
	@Column(name = "people_id")
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name = "full_name")
	private String name;
	
	@ManyToOne
	@JoinColumn(name="office_id")
	private Office office;
	
}
