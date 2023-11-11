package com.tyss.happyhome.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;
//LAMBOK ANNOTATIONS FOR GETTERS AND SETTERS
@Getter
@Setter
@Entity
public class Address {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String plotno;
	private String street;
	private String town;
	private String city;
	private String state;
	private long pincode;
	//USER MAPPING
	@OneToOne
	@JoinColumn(name="user_id")
	private Users user;
	//PROPERTY MAPPING
	@OneToOne
	@JoinColumn(name="property_id")
	private Property property;
	//DOCUMENT MAPPING
	@OneToOne
	@JoinColumn(name="document")
	private Document document;
}
