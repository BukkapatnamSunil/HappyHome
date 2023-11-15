package com.tyss.happyhome.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.tyss.happyhome.dao.ServiceDao;
import com.tyss.happyhome.dto.ResponseStructure;
import com.tyss.happyhome.entity.Service;
import com.tyss.happyhome.exception.IdDoesNotFoundException;
import com.tyss.happyhome.exception.Nullexception;
import com.tyss.happyhome.exception.PropertyTypeDoesnotFoundException;

@org.springframework.stereotype.Service
public class ServiceService {

	@Autowired
	private ServiceDao serviceDao;

	public ResponseEntity<ResponseStructure<com.tyss.happyhome.entity.Service>> saveService(Service service, int id) {
		Service recieveService = serviceDao.saveService(service, id);
		if (recieveService != null) {
			ResponseStructure<Service> responseStructure = new ResponseStructure<Service>();
			responseStructure.setStatusCode(HttpStatus.CREATED.value());
			responseStructure.setMessage("Success");
			responseStructure.setData(recieveService);
			return new ResponseEntity<ResponseStructure<Service>>(responseStructure, HttpStatus.CREATED);
		} else {
			throw new Nullexception();
		}
	}

	public ResponseEntity<ResponseStructure<Service>> updateService(Service property) {
		Service recieveService = serviceDao.updateService(property);
		ResponseStructure<Service> responseStructure = new ResponseStructure<Service>();
		responseStructure.setStatusCode(HttpStatus.OK.value());
		responseStructure.setMessage("Success");
		responseStructure.setData(recieveService);
		return new ResponseEntity<ResponseStructure<Service>>(responseStructure, HttpStatus.OK);
	}

	public ResponseEntity<ResponseStructure<Service>> deleteService(int id) {
		Service property = serviceDao.findByServiceId(id);
		if (property != null) {
			serviceDao.deleteServiceById(id);
			ResponseStructure<Service> responseStructure = new ResponseStructure<Service>();
			responseStructure.setStatusCode(HttpStatus.OK.value());
			responseStructure.setMessage("Success");
			responseStructure.setData(property);
			return new ResponseEntity<ResponseStructure<Service>>(responseStructure, HttpStatus.OK);
		} else {
			throw new IdDoesNotFoundException("Id : " + id + " is not present : ");
		}
	}

	public ResponseEntity<ResponseStructure<Service>> findServiceById(int id) {
		Service property = serviceDao.findByServiceId(id);
		if (property != null) {
			ResponseStructure<Service> responseStructure = new ResponseStructure<Service>();
			responseStructure.setStatusCode(HttpStatus.OK.value());
			responseStructure.setMessage("Success");
			responseStructure.setData(property);
			return new ResponseEntity<ResponseStructure<Service>>(responseStructure, HttpStatus.OK);
		} else {
			throw new IdDoesNotFoundException("Id : " + id + " is not present ");
		}
	}

	public ResponseEntity<ResponseStructure<List<Service>>> findByNameOfTheService(String nameOfTheService) {
		List<Service> services = serviceDao.findByNameOfTheService(nameOfTheService);
		if (!services.isEmpty()) {
			ResponseStructure<List<Service>> responseStructure = new ResponseStructure<List<Service>>();
			responseStructure.setStatusCode(HttpStatus.OK.value());
			responseStructure.setMessage("Success");
			responseStructure.setData(services);
			return new ResponseEntity<ResponseStructure<List<Service>>>(responseStructure, HttpStatus.OK);
		} else {
			throw new PropertyTypeDoesnotFoundException("Service of : " + nameOfTheService + " doesnot Found ");
		}
	}

	public ResponseEntity<ResponseStructure<List<Service>>> findByAvailability(String availability) {
		List<Service> services = serviceDao.findByAvailability(availability);
		if (!services.isEmpty()) {
			ResponseStructure<List<Service>> responseStructure = new ResponseStructure<List<Service>>();
			responseStructure.setStatusCode(HttpStatus.OK.value());
			responseStructure.setMessage("Success");
			responseStructure.setData(services);
			return new ResponseEntity<ResponseStructure<List<Service>>>(responseStructure, HttpStatus.OK);
		} else {
			throw new PropertyTypeDoesnotFoundException("Service of : " + availability + " doesnot Found ");
		}
	}
}
