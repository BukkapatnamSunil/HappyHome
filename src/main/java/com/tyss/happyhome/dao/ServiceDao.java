package com.tyss.happyhome.dao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tyss.happyhome.Repository.HappyHomeServicesRepository;
import com.tyss.happyhome.entity.Service;
import com.tyss.happyhome.entity.Users;

@Repository
public class ServiceDao {

	@Autowired
	private HappyHomeServicesRepository servicesRepository;

//	@Autowired
//	private ReviewDao reviewDao;

	@Autowired
	private UsersDao usersDao;

	// save the Service
	public Service saveService(Service service, int id) {
		Users users = usersDao.getUserById(id);
		if (users != null) {
			List<Users> user = new ArrayList<Users>();
			user.add(users);
			service.setList_user(user);
			return servicesRepository.save(service);
		} else {
			return null;
		}
	}

	// update the Service
	public Service updateService(Service service) {
		return servicesRepository.save(service);
	}

	// delete the service
	public void deleteService(Service service) {
		servicesRepository.delete(service);
	}

	// delete the service by Id
	public void deleteServiceById(int id) {
		Optional<Service> optional = servicesRepository.findById(id);
		if (optional.isPresent()) {
			Service service = optional.get();
			// get list of users who have using this service
			List<Users> users = service.getList_user();
			if (!users.isEmpty()) {
				// if it is not empty go to into each user
				for (Users users2 : users) {
					// each user have a list of service
					List<Service> services = users2.getList_service();
					if (!services.isEmpty()) {
						// each service we need to check with id
//						for (Service service1 : services) {
//							if (service.getId() == service1.getId()) {
//								// if id is matched make user as null for that servive
//								service1.setList_user(null);
//								services.remove(service1);
//							}
//						}
						
						Iterator<Service> iterator=services.iterator();
						while(iterator.hasNext()) {
							Service service1=iterator.next();
							if(service1.getId()==service.getId()) {
								iterator.remove();
							}
						}
					}
					users2.setList_service(services);
					usersDao.updateUser(users2);
				}

			}
			service.setList_user(null);
			servicesRepository.deleteById(id);
		}

	}

	// find the service by Id
	public Service findByServiceId(int id) {
		Optional<Service> optional = servicesRepository.findById(id);
		if (optional.isPresent()) {
			return optional.get();
		} else {
			return null;
		}
	}

	// find the service by Name Of the Service
	public List<Service> findByNameOfTheService(String nameOfService) {
		return servicesRepository.findByNameOfTheService(nameOfService);
	}

	// find the service by the direction
	public List<Service> findByAvailability(String availability) {
		return servicesRepository.findByAvailability(availability);
	}
}
