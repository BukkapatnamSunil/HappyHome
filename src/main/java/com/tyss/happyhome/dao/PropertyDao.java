package com.tyss.happyhome.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tyss.happyhome.Repository.HappyHomePropertyRepository;
import com.tyss.happyhome.entity.Property;

@Repository
public class PropertyDao {
	
	@Autowired
	private HappyHomePropertyRepository propertyRepository;
	
	public Property saveProperty(Property property) {
		return propertyRepository.save(property);
	}
	
	public Property updateProperty(Property property) {
		return propertyRepository.save(property);
	}
	
	public void deleteProperty(Property property) {
		propertyRepository.delete(property);
	}
	
	public void deletePropertyById(int id) {
		propertyRepository.deleteById(id);
	}
	
	public Property findByPropertyId(int id) {
		Optional<Property> optional=propertyRepository.findById(id);
		if(optional.isPresent()) {
			return optional.get();
		}else {
			return null;
		}
	}
	
	public List<Property> findPropertiesByType(String type){
		return propertyRepository.findByType(type);
	}
	
	public List<Property> findPropertiesBydirection(String direction){
		return propertyRepository.findByDirection(direction);
	}
	
	public List<Property> findPropertiesByCostGreaterThan(double cost){
		return propertyRepository.findByCostGreaterThan(cost);
	}
	
	public List<Property> findPropertiesByCostLessThan(double cost){
		return propertyRepository.findByCostLessThan(cost);
	}

}
