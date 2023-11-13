package com.tyss.happyhome.exception;

public class PropertyTypeDoesnotFoundException extends RuntimeException{

	private String message="Type not found";
	
	public PropertyTypeDoesnotFoundException() {
		
	}

	public PropertyTypeDoesnotFoundException(String message) {
		this.message = message;
	}
	
	@Override
	public String getMessage() {
		
		return this.message;
	}
	
	
}
