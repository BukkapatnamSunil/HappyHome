package com.tyss.happyhome.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tyss.happyhome.entity.Property;

public interface PropertyRepository extends JpaRepository<Property, Integer> {

	public List<Property> findByType(String type);
	public List<Property> findByCostGreaterThan(double cost);
	public List<Property> findByCostLessThan(double cost);
	public List<Property> findByDirection(String direction);
}
