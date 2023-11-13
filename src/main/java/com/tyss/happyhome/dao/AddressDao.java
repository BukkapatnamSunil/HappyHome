package com.tyss.happyhome.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.tyss.happyhome.Repository.HappyHomeAddressRepository;
import com.tyss.happyhome.entity.Address;
@RestController
public class AddressDao {
	@Autowired
	private HappyHomeAddressRepository addressrepository;
	//save address
	public Address saveAddress(Address address)
	{
		return addressrepository.save(address);
	}
	//get address object by id
	public Address getAddressById(int id)
	{
		Optional<Address> opt = addressrepository.findById(id);
		if(opt.isPresent())
		{
			return opt.get();
		}
		return null;
	}
	//get list of address
	public List<Address> getAllAddress()
	{
		List<Address> list = addressrepository.findAll();
		return list;
	}
	//update address
	public Address updateAddress(Address address)
	{
		return addressrepository.save(address);
	}
	//delete address
	public String deleteAddressById(int id)
	{
		Optional<Address> opt = addressrepository.findById(id);
		if(opt.isPresent())
		{
			Address add = opt.get();
			addressrepository.delete(add);
			return "Address of "+id+" is being deleted successfully";
		}
		return "No record found ";
	}

}
