package com.hcl.loan.model.exception;

public class ResourceNotFoundException extends RuntimeException{
	
	public ResourceNotFoundException(String message)
	{
		super(message);
	}

}
