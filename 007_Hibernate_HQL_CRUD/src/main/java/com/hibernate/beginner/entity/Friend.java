package com.hibernate.beginner.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Friend {

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(name = "friend_id")
	private long id;
	@Column(name = "friend_name")
	private String name;
	@Column(name = "friend_location")
	private String location;
	
}
