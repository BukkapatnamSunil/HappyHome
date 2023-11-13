package com.tyss.happyhome.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.tyss.happyhome.dao.PropertyDao;
import com.tyss.happyhome.dto.ResponseStructure;
import com.tyss.happyhome.entity.Property;
import com.tyss.happyhome.exception.IdDoesNotFoundException;
import com.tyss.happyhome.exception.PropertyTypeDoesnotFoundException;

@Service
public class PropertyService {

	@Autowired
	PropertyDao propertyDao;

	public ResponseEntity<ResponseStructure<Property>> saveProperty(Property property) {
		Property recieveProperty = propertyDao.saveProperty(property);
		ResponseStructure<Property> responseStructure = new ResponseStructure<Property>();
		responseStructure.setStatusCode(HttpStatus.CREATED.value());
		responseStructure.setMessage("Success");
		responseStructure.setData(recieveProperty);
		return new ResponseEntity<ResponseStructure<Property>>(responseStructure, HttpStatus.CREATED);
	}

	public ResponseEntity<ResponseStructure<Property>> updateProperty(Property property) {
		Property recieveProperty = propertyDao.updateProperty(property);
		ResponseStructure<Property> responseStructure = new ResponseStructure<Property>();
		responseStructure.setStatusCode(HttpStatus.OK.value());
		responseStructure.setMessage("Success");
		responseStructure.setData(recieveProperty);
		return new ResponseEntity<ResponseStructure<Property>>(responseStructure, HttpStatus.OK);
	}

	public ResponseEntity<ResponseStructure<Property>> deleteProperty(int id) {
		Property property = propertyDao.findByPropertyId(id);
		if (property != null) {
			propertyDao.deletePropertyById(id);
			ResponseStructure<Property> responseStructure = new ResponseStructure<Property>();
			responseStructure.setStatusCode(HttpStatus.OK.value());
			responseStructure.setMessage("Success");
			responseStructure.setData(property);
			return new ResponseEntity<ResponseStructure<Property>>(responseStructure, HttpStatus.OK);
		} else {
			throw new IdDoesNotFoundException("Id : " + id + " is not present : ");
		}
	}

	public ResponseEntity<ResponseStructure<Property>> findPropertyById(int id) {
		Property property = propertyDao.findByPropertyId(id);
		if (property != null) {
			ResponseStructure<Property> responseStructure = new ResponseStructure<Property>();
			responseStructure.setStatusCode(HttpStatus.OK.value());
			responseStructure.setMessage("Success");
			responseStructure.setData(property);
			return new ResponseEntity<ResponseStructure<Property>>(responseStructure, HttpStatus.OK);
		} else {
			throw new IdDoesNotFoundException("Id : " + id + " is not present ");
		}
	}

	public ResponseEntity<ResponseStructure<List<Property>>> findPropertyByType(String type){
		List<Property> property=propertyDao.findPropertiesByType(type);
		if(!property.isEmpty()) {
			ResponseStructure<List<Property>> responseStructure=new ResponseStructure<List<Property>>();
			responseStructure.setStatusCode(HttpStatus.OK.value());
			responseStructure.setMessage("Success");
			responseStructure.setData(property);
			return new ResponseEntity<ResponseStructure<List<Property>>>(responseStructure,HttpStatus.OK);
		}
		else {
			throw new PropertyTypeDoesnotFoundException("Type : "+type+" doesnot Found ");
		}
	}
	
	public ResponseEntity<ResponseStructure<List<Property>>> findPropertyByDirection(String direction){
		List<Property> property=propertyDao.findPropertiesBydirection(direction);
		if(!property.isEmpty()) {
			ResponseStructure<List<Property>> responseStructure=new ResponseStructure<List<Property>>();
			responseStructure.setStatusCode(HttpStatus.OK.value());
			responseStructure.setMessage("Success");
			responseStructure.setData(property);
			return new ResponseEntity<ResponseStructure<List<Property>>>(responseStructure,HttpStatus.OK);
		}
		else {
			throw new PropertyTypeDoesnotFoundException("Direction : "+direction+" doesnot Found ");
		}
	}
	
	public ResponseEntity<ResponseStructure<List<Property>>> findPropertyByCostGreaterThan(double cost){
		List<Property> property=propertyDao.findPropertiesByCostGreaterThan(cost);
		if(!property.isEmpty()) {
			ResponseStructure<List<Property>> responseStructure=new ResponseStructure<List<Property>>();
			responseStructure.setStatusCode(HttpStatus.OK.value());
			responseStructure.setMessage("Success");
			responseStructure.setData(property);
			return new ResponseEntity<ResponseStructure<List<Property>>>(responseStructure,HttpStatus.OK);
		}
		else {
			throw new PropertyTypeDoesnotFoundException("Cost : "+cost+" greater than doesnot Found ");
		}
	}
	
	public ResponseEntity<ResponseStructure<List<Property>>> findPropertyByCostLessThan(double cost){
		List<Property> property=propertyDao.findPropertiesByCostLessThan(cost);
		if(!property.isEmpty()) {
			ResponseStructure<List<Property>> responseStructure=new ResponseStructure<List<Property>>();
			responseStructure.setStatusCode(HttpStatus.OK.value());
			responseStructure.setMessage("Success");
			responseStructure.setData(property);
			return new ResponseEntity<ResponseStructure<List<Property>>>(responseStructure,HttpStatus.OK);
		}
		else {
			throw new PropertyTypeDoesnotFoundException("Cost : "+cost+" less than doesnot Found ");
		}
	}
}
