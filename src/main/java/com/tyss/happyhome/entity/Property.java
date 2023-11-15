package com.tyss.happyhome.entity;

import java.util.List;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;
//LAMBOK ANNOTATIONS FOR GETTERS AND SETTERS
@Entity
@Getter
@Setter
public class Property {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String type;
	private double squarefeet;
	private double cost;
	private String direction;
	//USER MAPPING
	@ManyToOne
	@JoinColumn(name="user_id")
	private Users user;
	//ADDRESS MAPPING
	@Cascade({CascadeType.PERSIST,CascadeType.DELETE,CascadeType.MERGE})
	@OneToOne(mappedBy = "property")
	private Address address;
	//DOCUMENT MAPPING
	@OneToOne(mappedBy = "property")
	private Document document;
	//REVIEW MAPPING
	@OneToMany(mappedBy = "property")
	private List<Review> list_reviews;
	
	
}
