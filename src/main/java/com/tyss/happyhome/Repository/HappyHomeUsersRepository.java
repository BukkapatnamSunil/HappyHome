package com.tyss.happyhome.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import com.tyss.happyhome.entity.Users;
import com.tyss.happyhome.utility.Role;
@Component
public interface HappyHomeUsersRepository  extends JpaRepository<Users, Integer>{

	Users findByEmail(String email);
	
	public List<Users> findByRole(Role role);

}
