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
	
	//save the Property
	public Property saveProperty(Property property) {
		return propertyRepository.save(property);
	}
	
	//update the Property
	public Property updateProperty(Property property) {
		return propertyRepository.save(property);
	}
	
	//Delete the Property
	public void deleteProperty(Property property) {
		propertyRepository.delete(property);
	}
	
	//Delete the Property by Id
	public void deletePropertyById(int id) {
		propertyRepository.deleteById(id);
	}
	
	//find the property by Id
	public Property findByPropertyId(int id) {
		Optional<Property> optional=propertyRepository.findById(id);
		if(optional.isPresent()) {
			return optional.get();
		}else {
			return null;
		}
	}
	
	//find the properties by type
	public List<Property> findPropertiesByType(String type){
		return propertyRepository.findByType(type);
	}
	
	//find properties by direction
	public List<Property> findPropertiesBydirection(String direction){
		return propertyRepository.findByDirection(direction);
	}
	
	//find properties by cost greater than 
	public List<Property> findPropertiesByCostGreaterThan(double cost){
		return propertyRepository.findByCostGreaterThan(cost);
	}
	
	//find properties by cost less than 
	public List<Property> findPropertiesByCostLessThan(double cost){
		return propertyRepository.findByCostLessThan(cost);
	}
	
	

}
