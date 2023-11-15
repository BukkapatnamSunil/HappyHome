package com.tyss.happyhome.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
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
	@JsonIgnore
	@JoinColumn(name="property_id")
	private Property property;
	
	// SERVICE MAPPING 
	@ManyToOne
	@JoinColumn(name="my_review_Id")
	private Service service;
}
