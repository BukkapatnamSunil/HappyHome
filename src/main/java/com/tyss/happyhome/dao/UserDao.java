package com.tyss.happyhome.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tyss.happyhome.Repository.HappyHomeUserRepository;
import com.tyss.happyhome.entity.Users;

//@Repository
@RestController
public class UserDao {
	
	@Autowired
	private HappyHomeUserRepository userRepository;
	
	//to save user
	@PostMapping("/save")
	public Users saveUser(Users users)
	{
		return userRepository.save(users);
	}
	
	//to get user based on id
	@GetMapping("/get/{id}")
	public Users getUserById(int id)
	{
		Optional<Users> opt = userRepository.findById(id);
		if(opt.isPresent())
		{
			return opt.get();
		}
		else
		{
			return null;
		}
	}
	
	//to get user by email
	@GetMapping("/getemail/{email}")
	public Users findByEmail(String email)
	{
		Users us = userRepository.findByEmail(email);
		if(us!=null)
		{
			return us;
		}
		else
		{
			return null;
		}
	}
	
	//to get list of users
	public List<Users> getAllUsers()
	{
		List<Users> users = userRepository.findAll();
		return users;
	}
	
	//to update user record
	public Users updateUser(Users user)
	{
		Users us = userRepository.save(user);
		return us;
	}
	
	//to delete user record
	public String deleteUserById(int id)
	{
		Optional<Users> opt = userRepository.findById(id);
		if(opt.isPresent())
		{
			Users user = opt.get();
			userRepository.delete(user);
			return " User Id: "+id+" deleted successfully";
		}
		else
		{
			return "Id not found";
		}
	}
}
