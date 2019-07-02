package com.hibernate.beginner.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Friend {
	
	private String id;
	private String name;
	private String location;
	

}
