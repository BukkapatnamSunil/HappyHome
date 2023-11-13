package com.tyss.happyhome.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tyss.happyhome.entity.Users;

public interface HappyHomeUsersRepository extends JpaRepository<Users, Integer>{

}
