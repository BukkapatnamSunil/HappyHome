package com.tyss.happyhome.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.tyss.happyhome.dto.ResponseStructure;
import com.tyss.happyhome.entity.Property;
import com.tyss.happyhome.service.PropertyService;

@RestController
public class PropertyController {

	@Autowired
	private PropertyService propertyService;
	
	@PostMapping("/property")
	public ResponseEntity<ResponseStructure<Property>> saveProperty(@RequestBody Property property){
		return propertyService.saveProperty(property);
	}
	
	@PutMapping("/property")
	public ResponseEntity<ResponseStructure<Property>> updateProperty(@RequestBody Property property){
		return propertyService.updateProperty(property);
	}
	
	@DeleteMapping("/property/{id}")
	public ResponseEntity<ResponseStructure<Property>> deletePropertyById(@PathVariable int id){
		return propertyService.deleteProperty(id);
	}
	
	@GetMapping("/property/{id}")
	public ResponseEntity<ResponseStructure<Property>> findPropertyById(@PathVariable int id){
		return propertyService.findPropertyById(id);
	}
	
	@GetMapping("/property/{type}")
	public ResponseEntity<ResponseStructure<List<Property>>> findPropertyByType(@PathVariable String type){
		return propertyService.findPropertyByType(type);
	}
	
	@GetMapping("/properties/{direction}")
	public ResponseEntity<ResponseStructure<List<Property>>> findPropertyByDirection(@PathVariable String direction){
		return propertyService.findPropertyByDirection(direction);
	}
	
	@GetMapping("/properties/{cost}")
	public ResponseEntity<ResponseStructure<List<Property>>> findPropertyByCostGreaterThan(@PathVariable double cost){
		return propertyService.findPropertyByCostGreaterThan(cost);
	}
	
	@GetMapping("/property/{cost}")
	public ResponseEntity<ResponseStructure<List<Property>>> findPropertyByCostLessThan(@PathVariable double cost){
		return propertyService.findPropertyByCostLessThan(cost);
	}
}
