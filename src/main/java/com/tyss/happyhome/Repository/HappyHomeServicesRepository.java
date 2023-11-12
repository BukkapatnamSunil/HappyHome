package com.tyss.happyhome.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import com.tyss.happyhome.entity.Service;

@Component
public interface HappyHomeServicesRepository  extends JpaRepository<Service, Integer>{
	
}
