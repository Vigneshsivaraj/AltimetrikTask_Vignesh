package com.task.vehiclemanagementsystem.exceptions;

import org.springframework.http.HttpStatus;

public class ValidationException extends ApiErrorResponse {
	  public ValidationException(String message) {
	        super(message, HttpStatus.NOT_FOUND);
	    }
}
