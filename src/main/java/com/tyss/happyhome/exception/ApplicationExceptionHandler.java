package com.tyss.happyhome.exception;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.tyss.happyhome.dto.ResponseStructure;

@ControllerAdvice
public class ApplicationExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(IdDoesNotFoundException.class)
	public ResponseEntity<ResponseStructure<String>> catchIdDoesNotPresentException(
			IdDoesNotFoundException idDoesNotFoundException) {
		ResponseStructure<String> responseStructure = new ResponseStructure<String>();
		responseStructure.setStatusCode(HttpStatus.NOT_FOUND.value());
		responseStructure.setMessage(idDoesNotFoundException.getMessage());
		responseStructure.setData("Not Found");
		return new ResponseEntity<ResponseStructure<String>>(responseStructure, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(PropertyTypeDoesnotFoundException.class)
	public ResponseEntity<ResponseStructure<List<String>>> catchPropertyTypeDoesnotFoundException(
			PropertyTypeDoesnotFoundException doesnotFoundException) {
		ResponseStructure<List<String>> responseStructure = new ResponseStructure<List<String>>();
		responseStructure.setStatusCode(HttpStatus.NOT_FOUND.value());
		responseStructure.setMessage(doesnotFoundException.getMessage());
		responseStructure.setData(null);
		return new ResponseEntity<ResponseStructure<List<String>>>(responseStructure, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(EmailDoesNotFoundException.class)
	public ResponseEntity<ResponseStructure<String>> catchEmailDoesNotPresentException(
			EmailDoesNotFoundException emailDoesNotFoundException) {
		ResponseStructure<String> responseStructure = new ResponseStructure<String>();
		responseStructure.setStatusCode(HttpStatus.NOT_FOUND.value());
		responseStructure.setMessage("Not Found");
		responseStructure.setData(null);
		return new ResponseEntity<ResponseStructure<String>>(responseStructure, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(Nullexception.class)
	public ResponseEntity<ResponseStructure<String>> handleNullPointerException(Nullexception nullexception)

	{
		ResponseStructure<String> responseStructure = new ResponseStructure<String>();
		responseStructure.setStatusCode(HttpStatus.NOT_FOUND.value());
		responseStructure.setMessage(nullexception.getMessage());
		responseStructure.setData("Data Not Found");
		return new ResponseEntity<ResponseStructure<String>>(responseStructure, HttpStatus.NOT_FOUND);

	}
}
