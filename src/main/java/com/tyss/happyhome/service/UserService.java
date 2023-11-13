package com.tyss.happyhome.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.tyss.happyhome.dao.UsersDao;
import com.tyss.happyhome.dto.ResponseStructure;
import com.tyss.happyhome.entity.Users;
import com.tyss.happyhome.exception.EmailDoesNotFoundException;
import com.tyss.happyhome.exception.IdDoesNotFoundException;

@Service
@Component
public class UserService {

	@Autowired
	private UsersDao userDao;

	public ResponseEntity<ResponseStructure<Users>> saveUser(Users user) {

		Users receivedUser = userDao.saveUser(user);
		ResponseStructure<Users> responseStructure = new ResponseStructure<Users>();
		responseStructure.setStatusCode(201);
		responseStructure.setMessage("Success");
		responseStructure.setData(receivedUser);

		return new ResponseEntity<ResponseStructure<Users>>(responseStructure, HttpStatus.CREATED);
	}

	public ResponseEntity<ResponseStructure<Users>> getUserById(int id) {
		Users user = userDao.getUserById(id);
		if (user != null) {
			ResponseStructure<Users> responseStructure = new ResponseStructure<Users>();
			responseStructure.setStatusCode(HttpStatus.OK.value());
			responseStructure.setMessage("SUCCESS");
			responseStructure.setData(user);

			return new ResponseEntity<ResponseStructure<Users>>(responseStructure, HttpStatus.CREATED);
		} else {
			throw new IdDoesNotFoundException("ID: " + id + ", not present in DB");
		}
	}

	public ResponseEntity<ResponseStructure<Users>> findByEmail(String email) {
		Users user = userDao.findByEmail(email);
		if (user != null) {
			ResponseStructure<Users> responseStructure = new ResponseStructure<Users>();
			responseStructure.setStatusCode(HttpStatus.OK.value());
			responseStructure.setMessage("SUCCESS");
			responseStructure.setData(user);

			return new ResponseEntity<ResponseStructure<Users>>(responseStructure, HttpStatus.CREATED);
		} else {
			throw new EmailDoesNotFoundException("Email: " + email + ", not present in DB");
		}
	}

	public ResponseEntity<ResponseStructure<List<Users>>> getAllUsers() {

		List<Users> users = userDao.getAllUsers();

		ResponseStructure<List<Users>> responseStructure = new ResponseStructure<>();
		responseStructure.setStatusCode(HttpStatus.OK.value());
		responseStructure.setMessage("Reviews retrieved successfully");
		responseStructure.setData(users);

		return new ResponseEntity<ResponseStructure<List<Users>>>(responseStructure, HttpStatus.OK);
	}

	public ResponseEntity<ResponseStructure<Users>> updateUser(Users user) {

		Users updated = userDao.updateUser(user);

		ResponseStructure<Users> responseStructure = new ResponseStructure<Users>();

		if (updated != null) {
			responseStructure.setStatusCode(HttpStatus.OK.value());
			responseStructure.setMessage("User updated successfully");
			responseStructure.setData(updated);
			return new ResponseEntity<>(responseStructure, HttpStatus.OK);
		} else {
			responseStructure.setStatusCode(HttpStatus.NOT_FOUND.value());
			responseStructure.setMessage("Failed to update the user");
			return new ResponseEntity<>(responseStructure, HttpStatus.NOT_FOUND);
		}
	}

	public ResponseEntity<ResponseStructure<String>> deleteUserById(int id) {

		Users user = userDao.getUserById(id);
		if (user != null) {
			userDao.deleteUserById(id);
			ResponseStructure<String> responseStructure = new ResponseStructure<String>();
			responseStructure.setStatusCode(HttpStatus.OK.value());
			responseStructure.setMessage("Success");
			responseStructure.setData("User is deleted");
			return new ResponseEntity<ResponseStructure<String>>(responseStructure, HttpStatus.OK);
		} else {
			throw new IdDoesNotFoundException("Id : " + id + " is not present : ");
		}
	}
	
}
