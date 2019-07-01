package com.hibernate.beginner.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "friendannotation") 
public class Friend {

	@Id
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	@GeneratedValue (strategy = GenerationType.TABLE, generator = "friend_gen")
	@TableGenerator(name = "friend_gen", table = "pk_generator", pkColumnName = "pk_field", valueColumnName = "pk_value", allocationSize = 1)
	private int id;
	@Column (name = "fullName")
	private String name;
	@Column (name="friendLocation")
	private String location;
	@Column (name="friendEmail")
	private String email;
	
	
}
