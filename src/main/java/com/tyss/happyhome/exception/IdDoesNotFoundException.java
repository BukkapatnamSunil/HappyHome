package com.tyss.happyhome.exception;

public class IdDoesNotFoundException extends RuntimeException{
	
	private String message = "Id is not present";

	
	public IdDoesNotFoundException() {
		
	}
	
	public IdDoesNotFoundException(String message) {
		this.message = message;
	}
	
	@Override
	public String getMessage() {
		
		return message;
	}

	
	
}
