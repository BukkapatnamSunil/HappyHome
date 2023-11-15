package com.tyss.happyhome.entity;

import java.util.List;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import com.tyss.happyhome.utility.Role;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

//LAMBOK ANNOTATIONS FOR GETTERS AND SETTERS
@Entity
@Getter
@Setter
@NoArgsConstructor
public class Users {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	@Column(unique=true)
	private String email;
	private String password;
	@Column(unique=true)
	private long phno;
	private Role role;
	//ADDRESS MAPPING
	@Cascade({CascadeType.ALL})
	@OneToOne(mappedBy = "user")
    private Address address;
	//PROPERTY MAPPING
	@OneToMany(mappedBy = "user")
	private List<Property> list_property;
	//SERVICES MAPPING
	@ManyToMany(mappedBy = "list_user")
	private List<Service> list_service;
	//DOCUMENT MAPPING
	@OneToMany(mappedBy = "user")
	private List<Document> list_document;
    
	
}
