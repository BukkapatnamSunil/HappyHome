package com.tyss.happyhome.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.tyss.happyhome.entity.Service;

public interface ServicesRepository  extends JpaRepository<Service, Integer>{

	public List<Service> findByNameOfTheService(String nameOfTheService);
	public List<Service> findByAvailability(String availability);
}
