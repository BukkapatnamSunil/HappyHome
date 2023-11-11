package com.tyss.happyhome.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tyss.happyhome.entity.Address;

public interface HappyHomeAddressRepository  extends JpaRepository<Address, Integer>{

}
