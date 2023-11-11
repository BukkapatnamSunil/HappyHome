package com.tyss.happyhome.entity;


import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import lombok.Getter;
import lombok.Setter;
//LAMBOK ANNOTATIONS FOR GETTERS AND SETTERS
@Getter
@Setter
@Entity
public class Service {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String nameOfTheService;
	private String availability;
	private double price;
	private String serviceDetails;
	@Column(unique = true)
	private long phone;
	//USER MAPPING
	@ManyToMany
	@JoinTable(joinColumns = @JoinColumn(name="service_id"),inverseJoinColumns =@JoinColumn(name="user_id") )
	private List<Users> list_user;
	//REVIEW MAPPING
	@ManyToMany
	@JoinTable(joinColumns = @JoinColumn(name="service_id"),inverseJoinColumns = @JoinColumn(name="review_id"))
	private List<Review> list_review;
	
}
