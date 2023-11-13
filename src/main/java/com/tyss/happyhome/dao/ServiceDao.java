package com.tyss.happyhome.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tyss.happyhome.Repository.HappyHomeServicesRepository;
import com.tyss.happyhome.entity.Service;

@Repository
public class ServiceDao {

	@Autowired
	private HappyHomeServicesRepository servicesRepository;
	
	//save the Service
	public Service saveService(Service service) {
		return servicesRepository.save(service);
	}
	
	//update the Service
	public Service updateService(Service service) {
		return servicesRepository.save(service);
	}
	
	//delete the service
	public void deleteService(Service service) {
		servicesRepository.delete(service);
	}
	
	//delete the service by Id
	public void deleteServiceById(int id) {
		servicesRepository.deleteById(id);
	}
	
	//find the service by Id
	public Service findByServiceId(int id) {
		Optional<Service> optional=servicesRepository.findById(id);
		if(optional.isPresent()) {
			return optional.get();
		}else {
			return null;
		}
	}
	
	//find the service by Name Of the Service
	public List<Service> findByNameOfTheService(String nameOfService){
		return servicesRepository.findByNameOfTheService(nameOfService);
	}
	
	//find the service by the direction
	public List<Service> findByAvailability(String availability){
		return servicesRepository.findByAvailability(availability);
	}
}
