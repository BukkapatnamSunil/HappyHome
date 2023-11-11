package com.tyss.happyhome.entity;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;
//LAMBOK ANNOTATIONS FOR GETTERS AND SETTERS
@Entity
@Getter
@Setter
public class Review {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String description;
	//PROPERTY MAPPING
	@ManyToOne
	@JoinColumn(name="property_id")
	private Property property;
	
	// SERVICE MAPPING 
	@ManyToMany(mappedBy = "list_review")
	private List<Service> list_services;
}
