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
import javax.persistence.ManyToMany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity (name="student_table")
public class Student {

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(name = "student_id")
	private int id;
	@Column(name = "student_name")
	private String name;
	@Column(name = "student_score")
	private int score;
	
	@ManyToMany
	@JoinTable (name = "student_course_mapping", joinColumns = {@JoinColumn(name ="student_id")}, inverseJoinColumns = {@JoinColumn(name ="course_id")})
	private Collection<Course> courses = new ArrayList<Course>(); 

}
