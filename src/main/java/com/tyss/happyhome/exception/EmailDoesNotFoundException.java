package com.tyss.happyhome.exception;

public class EmailDoesNotFoundException extends RuntimeException{
	
	private String message = "Email is not present";

	
	public EmailDoesNotFoundException() {
		
	}
	
	public EmailDoesNotFoundException(String message) {
		this.message = message;
	}
	
	public String getMessage() 
	{
		return message;
	}
	
}
