package com.tyss.happyhome.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.tyss.happyhome.dto.ResponseStructure;
import com.tyss.happyhome.entity.Address;
import com.tyss.happyhome.service.AddressService;

@RestController
public class AddressController {
	@Autowired
	private AddressService addressService;
	//SAVE ADDRESS
	@PostMapping("/saveaddress")
	public ResponseEntity<ResponseStructure<Address>> saveAddress(@RequestBody Address address)
	{
		return addressService.saveAddress(address);
	}
	//GET ADDRESS BY ID
	@GetMapping("/findbyid/{id}")
	public ResponseEntity<ResponseStructure<Address>> findById(@PathVariable int id)
	{
		return addressService.getById(id);
	}
	//GET ALL ADDRESSES
	@GetMapping("/getalladdress")
	public ResponseEntity<ResponseStructure<List<Address>>> getAllAddress()
	{
		return addressService.getAllAddress();
	}
	//UPDATE ADDRESS
	@GetMapping("/updateaddress")
	public ResponseEntity<ResponseStructure<Address>> updateAddress(@RequestBody Address address)
	{
		return addressService.UpdateAddress(address);
	}
	//DELETE ADDRESS
	@GetMapping("/deleteaddress/{id}")
	public ResponseEntity<ResponseStructure<String>> deleteAddress(@PathVariable int id)
	{
		return addressService.deleteAddressById(id);
	}

}
