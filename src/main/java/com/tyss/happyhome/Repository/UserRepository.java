package com.tyss.happyhome.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tyss.happyhome.entity.Users;

public interface UserRepository extends JpaRepository<Users, Integer>{

}
