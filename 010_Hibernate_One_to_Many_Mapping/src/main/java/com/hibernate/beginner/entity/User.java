package com.hibernate.beginner.entity;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity (name = "regsitered_user")
public class User {
	
	@Id
	@Column(name = "id")
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private int user_id;
	
	@Column(name = "user_name")
	private String username;
	
	@OneToMany
	@JoinTable(name = "user_address_mapping", joinColumns = @JoinColumn(name="id"), inverseJoinColumns = @JoinColumn(name="add_id"))
	private Collection<Address> address = new ArrayList<Address>(); 
	
	
	

}
