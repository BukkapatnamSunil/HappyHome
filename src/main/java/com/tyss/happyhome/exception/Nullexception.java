package com.tyss.happyhome.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class Nullexception extends RuntimeException{
	
private String message = "no data available and trying to access null";

	
	 public Nullexception() {
		// TODO Auto-generated constructor stub
	}
	
	public Nullexception(String message) {
		this.message = message;
	}
	
	public String getMessage() 
	{
		return message;
	}

	
	
	}
