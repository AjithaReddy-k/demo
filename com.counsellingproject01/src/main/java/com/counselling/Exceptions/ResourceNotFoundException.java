package com.counselling.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)

public class ResourceNotFoundException extends Exception //RuntimeException{
{
//    private String resourceName;
//
//    private String fieldName;
//
//    private int fieldValue;
//
// 
//
//    public ResourceNotFoundException(String resourceName, String fieldName, int fieldValue) {
//
//        super(String.format("%s not found with %s : '%s'", resourceName, fieldName, fieldValue)); // Post not found with id : 1
//
//        this.resourceName = resourceName;
//
//        this.fieldName = fieldName;
//
//        this.fieldValue = fieldValue;
//
//    }
//
// 
//
//    public String getResourceName() {
//
//        return resourceName;
//
//    }
//
// 
//
//    public String getFieldName() {
//
//        return fieldName;
//
//    }
//
// 
//
//    public long getFieldValue() {
//
//        return fieldValue;
//
//    }

	private String errorMessage;
private String resourceName;
private String fieldName;
private int fieldValue;

	
	
	@Override
	public String getMessage() {
		return errorMessage;
	}



	public ResourceNotFoundException() {
		super();
	}



	 public ResourceNotFoundException(String resourceName, String fieldName, int fieldValue) {
		 
		         super(String.format("%s not found with %s : '%s'", resourceName, fieldName, fieldValue)); // Post not found with id : 1
		 
		         this.resourceName = resourceName;
		 
		         this.fieldName = fieldName;
		 
		         this.fieldValue = fieldValue;
		 
		     }



	public ResourceNotFoundException(String errorMessage) {
		super();
		this.errorMessage = errorMessage;
	}


	
	
}