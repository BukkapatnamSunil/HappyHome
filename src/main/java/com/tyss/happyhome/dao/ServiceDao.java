package com.tyss.happyhome.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tyss.happyhome.Repository.ServicesRepository;
import com.tyss.happyhome.entity.Service;

@Repository
public class ServiceDao {

	@Autowired
	private ServicesRepository servicesRepository;
	
	public Service saveProperty(Service service) {
		return servicesRepository.save(service);
	}
	
	public Service updateProperty(Service service) {
		return servicesRepository.save(service);
	}
	
	public void deleteProperty(Service service) {
		servicesRepository.delete(service);
	}
	
	public void deletePropertyById(int id) {
		servicesRepository.deleteById(id);
	}
	
	public Service findByPropertyId(int id) {
		Optional<Service> optional=servicesRepository.findById(id);
		if(optional.isPresent()) {
			return optional.get();
		}else {
			return null;
		}
	}
	
	public List<Service> findByNameOfTheService(String nameOfService){
		return servicesRepository.findByNameOfTheService(nameOfService);
	}
	
	public List<Service> findPropertiesBydirection(String availability){
		return servicesRepository.findByAvailability(availability);
	}
}
