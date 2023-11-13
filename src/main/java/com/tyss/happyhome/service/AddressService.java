package com.tyss.happyhome.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.tyss.happyhome.dao.AddressDao;
import com.tyss.happyhome.dto.ResponseStructure;
import com.tyss.happyhome.entity.Address;
import com.tyss.happyhome.exception.IdDoesNotFoundException;
import com.tyss.happyhome.exception.Nullexception;

@Service
@Component
public class AddressService {
	@Autowired
	private AddressDao ad;
	
	//SAVE ADDRESS SERVICE METHOD
	public ResponseEntity<ResponseStructure<Address>> saveAddress(Address address)
	{
		Address address1=ad.saveAddress(address);
		ResponseStructure<Address> response=new ResponseStructure<>();
		response.setStatusCode(HttpStatus.OK.value());
		response.setMessage("Success");
		response.setData(address1);
		return new ResponseEntity<ResponseStructure<Address>>(response,HttpStatus.OK);
	}
	//GET ADDRESS BY ID service method
	public ResponseEntity<ResponseStructure<Address>> getById(int id)
	{
		Address address1=ad.getAddressById(id);
		if(address1!=null) {
		ResponseStructure<Address> response=new ResponseStructure<>();
		response.setStatusCode(HttpStatus.FOUND .value());
		response.setMessage("Success");
		response.setData(address1);
		return new ResponseEntity<ResponseStructure<Address>>(response,HttpStatus.FOUND);
		}
		else {
			ResponseStructure<Address> response=new ResponseStructure<>();
			response.setStatusCode(HttpStatus.NOT_FOUND .value());
			response.setMessage("not found");
			response.setData(null);
			return new ResponseEntity<ResponseStructure<Address>>(response,HttpStatus.NOT_FOUND);
			
		}
	}
	
	//GET ALL THE ADDRESS AVAILABLE BY SERVICE METHOD
	public ResponseEntity<ResponseStructure<List<Address>>> getAllAddress()
	{
		List<Address> list=ad.getAllAddress();
		if(list!=null)
		{
			ResponseStructure<List<Address>> response=new ResponseStructure<>();
			response.setStatusCode(HttpStatus.ACCEPTED  .value());
			response.setMessage("Success");
			response.setData(list);
			return new ResponseEntity<ResponseStructure<List<Address>>>(response,HttpStatus.ACCEPTED);
			
		}
		else {
			
			throw new Nullexception();
		}
	}
	
	// UPDATE ADDRESS SERVICE METHOD
	public ResponseEntity<ResponseStructure<Address>> UpdateAddress(Address address)
	{
		Address address1=ad.updateAddress(address);
		if(address1!=null) {
			ResponseStructure<Address> response=new ResponseStructure<>();
			response.setStatusCode(HttpStatus.FOUND .value());
			response.setMessage("Success");
			response.setData(address1);
			return new ResponseEntity<ResponseStructure<Address>>(response,HttpStatus.FOUND);
			}
			else {
				ResponseStructure<Address> response=new ResponseStructure<>();
				response.setStatusCode(HttpStatus.NOT_FOUND .value());
				response.setMessage("not found");
				response.setData(null);
				return new ResponseEntity<ResponseStructure<Address>>(response,HttpStatus.NOT_FOUND);
				
			}
		
	}
	//DELETE ADDRESS BY ID SERVICE METHOD
	public ResponseEntity<ResponseStructure<String>> deleteAddressById(int id)
	{
		Optional<Address> result=ad.deleteAddressById(id);
        ResponseStructure<String> responseStructure = new ResponseStructure<>();

		 if (result!=null) {
	            responseStructure.setStatusCode(HttpStatus.OK.value());
	            responseStructure.setMessage("Address deleted successfully");
	            responseStructure.setData("address with ID " + id + " has been deleted");
	            return new ResponseEntity<>(responseStructure, HttpStatus.OK);
	        } 
		 else {
	            responseStructure.setStatusCode(HttpStatus.NOT_FOUND.value());
	            responseStructure.setMessage("Failed to delete the document");
	            responseStructure.setData("Address with ID " + id + " not found");
	            return new ResponseEntity<>(responseStructure, HttpStatus.NOT_FOUND);
	        }

	}

	

}
