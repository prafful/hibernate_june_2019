package com.hibernate.beginner.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table (name = "pan_card")
public class PAN {

	@Id
	@Column(name="pan_card_id")
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private int pan_id;
	@Column(name="pan_number")
	private String panNumber;
	
}
