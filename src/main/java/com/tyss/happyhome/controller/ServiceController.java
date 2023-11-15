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
import com.tyss.happyhome.entity.Service;
import com.tyss.happyhome.service.ServiceService;

@RestController
public class ServiceController {

	@Autowired
	private ServiceService service;

	@PostMapping("/service/{id}")
	public ResponseEntity<ResponseStructure<Service>> saveService(@RequestBody Service service2, @PathVariable int id) {
		return service.saveService(service2, id);
	}

	@PutMapping("/service")
	public ResponseEntity<ResponseStructure<Service>> updateService(@RequestBody Service property) {
		return service.updateService(property);
	}

	@DeleteMapping("/service/{id}")
	public ResponseEntity<ResponseStructure<Service>> deleteServiceById(@PathVariable int id) {
		return service.deleteService(id);
	}

	@GetMapping("/findservice/{id}")
	public ResponseEntity<ResponseStructure<Service>> findServiceById(@PathVariable int id) {
		return service.findServiceById(id);
	}

	@GetMapping("/service/{nameOfTheService}")
	public ResponseEntity<ResponseStructure<List<Service>>> findServiceByNameOfTheService(
			@PathVariable String nameOfTheService) {
		return service.findByNameOfTheService(nameOfTheService);
	}

	@GetMapping("/services/{availability}")
	public ResponseEntity<ResponseStructure<List<Service>>> findServiceByAvaialability(
			@PathVariable String availability) {
		return service.findByAvailability(availability);
	}

}
