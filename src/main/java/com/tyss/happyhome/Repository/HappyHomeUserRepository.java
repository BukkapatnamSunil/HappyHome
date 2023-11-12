package com.tyss.happyhome.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import com.tyss.happyhome.entity.Users;

@Component
public interface HappyHomeUserRepository extends JpaRepository<Users, Integer>{
	
	Users findByEmail(String email);
} 
