package com.task.vehiclemanagementsystem.exceptions;

import org.springframework.http.HttpStatus;

public class ResourceNotFoundException extends ApiErrorResponse {
	  public ResourceNotFoundException(String message) {
	        super(message, HttpStatus.NOT_FOUND);
	    }
}
