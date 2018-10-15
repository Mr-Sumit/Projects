package com.learning.exception;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
@ControllerAdvice
@RestController
public class CustomizedResponseEntityExceptionHandler extends ResponseEntityExceptionHandler{
	
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<ApiError> handleResourceNotFoundException(ResourceNotFoundException ex, WebRequest request){
		ApiError apiError = new ApiError(HttpStatus.NOT_FOUND, new Date(), "Requsted Resource doesn't exist");
		return new ResponseEntity<>(apiError, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(UsernameFoundException.class)
	public ResponseEntity<ApiError> handleUsernameFoundException(UsernameFoundException ex, WebRequest request){
		ApiError apiError = new ApiError(HttpStatus.FOUND, new Date(), "Username already exist");
		return new ResponseEntity<>(apiError, HttpStatus.FOUND);
	}
}