package com.tyss.happyhome.entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;

//LAMBOK ANNOTATIONS FOR GETTERS AND SETTERS
@Setter
@Getter
@Entity
public class Document {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String documnetType;
	@Column(unique = true)
	private String documnetNumber;
	private LocalDate issueDate;
	//USER MAPPING
	@ManyToOne
	@JoinColumn(name="user_id")
	private Users user;
	//PROPERTY MAPPING
	@OneToOne
	@JoinColumn(name="property_id")
	private Property property;
	//ADDRESS MAPPING
	@OneToOne(mappedBy = "document")
	private Address address;
	
}
