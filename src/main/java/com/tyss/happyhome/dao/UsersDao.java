package com.tyss.happyhome.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.tyss.happyhome.Repository.HappyHomeAddressRepository;
import com.tyss.happyhome.Repository.HappyHomeUsersRepository;
import com.tyss.happyhome.entity.Service;
import com.tyss.happyhome.entity.Users;

@Repository
public class UsersDao {
	@Autowired
	private HappyHomeUsersRepository userRepository;
	
	//method to save user
	public Users saveUser(Users users)
	{
		return userRepository.save(users);
	}
	
	//method to get user based on id
	public Users getUserById(int id)
	{
		Optional<Users> opt = userRepository.findById(id);
		if(opt.isPresent())
		{
			return opt.get();
		}
		return null;
	}
	
	//method to get user based on email
	public Users findByEmail(String email)
	{
		Users user = userRepository.findByEmail(email);
		if(user!=null)
		{
			return user;
		}
		return null;
	}
	
	//method to get list of users
	public List<Users> getAllUsers()
	{
		List<Users> list = userRepository.findAll();
		return list;
	}
	
	//method to find list of services
//	public List<Service> findByList_service(int id)
//	{
//		Optional<Users> opt = userRepository.findById(id);
//		if(opt.isPresent())
//		{
//			List<Service> list = opt.get().getList_service();
//			return list;
//		}
//		return null;
//	}
	
	//method to update user
	public Users updateUser(Users user)
	{
		return userRepository.save(user);
	}
	
	//method to delete user based on id
	public String deleteUserById(int id)
	{
		Optional<Users> opt = userRepository.findById(id);
		if(opt.isPresent())
		{
			Users us = opt.get();
			userRepository.delete(us);
			return "User id: "+id+" deleted successfully";
		}
		return "No record found to delete";
	}
}