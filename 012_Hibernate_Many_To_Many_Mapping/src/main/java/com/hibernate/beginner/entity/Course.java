package com.hibernate.beginner.entity;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity (name="course_table")
public class Course {
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column (name = "course_id")
	private int id;
	@Column(name = "course_name")
	private String name;
	@Column (name = "course_duration")
	private int duration;
	
	@ManyToMany (mappedBy = "courses")
	private Collection<Student> students = new ArrayList<Student>(); 

}
