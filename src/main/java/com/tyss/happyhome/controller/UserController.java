package com.tyss.happyhome.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.tyss.happyhome.dto.ResponseStructure;
import com.tyss.happyhome.entity.Users;
import com.tyss.happyhome.service.UserService;
import com.tyss.happyhome.utility.Role;

@RestController
public class UserController {

	@Autowired
	private UserService userService;

	@PostMapping("/userSave")
	public ResponseEntity<ResponseStructure<Users>> saveUser(@RequestBody Users user) {
		return userService.saveUser(user);
	}

	@PutMapping("/users")
	public ResponseEntity<ResponseStructure<Users>> updateUser(@RequestBody Users user) {
		return userService.updateUser(user);
	}

	@DeleteMapping("/deleteUser/{id}")
	public ResponseEntity<ResponseStructure<String>> deleteUserById(@PathVariable int id) {
		return userService.deleteUserById(id);
	}

	@GetMapping("/users/{id}")
	public ResponseEntity<ResponseStructure<Users>> getUserById(@PathVariable int id) {
		return userService.getUserById(id);
	}

	@GetMapping("/usersEmail/{email}")
	public ResponseEntity<ResponseStructure<Users>> getEmployeeByEmail(@PathVariable String email) {
		return userService.findByEmail(email);
	}

	@GetMapping("/getAllusers")
	public ResponseEntity<ResponseStructure<List<Users>>> getAllUsers() {
		return userService.getAllUsers();
	}

	@PutMapping("/users/{id}/{password}")
	public ResponseEntity<ResponseStructure<Users>> updatePassword(@PathVariable int id,@PathVariable String password) {
		return userService.updatePassword(id, password);
	}

	@GetMapping("/usersrole/{role}")
	public ResponseEntity<ResponseStructure<List<Users>>> getUserRole(@PathVariable Role role) {
		return userService.findByRole(role);
	}

}