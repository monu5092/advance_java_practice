package com.ecom.inventory.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
      
	@ExceptionHandler(InventoryNotFoundException.class)
	public ResponseEntity<ErrorResponse> handleNotFound(InventoryNotFoundException ex)
	{
		return new ResponseEntity<>(
				new ErrorResponse(ex.getMessage(), 404),HttpStatus.NOT_FOUND);
	}
	
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorResponse> handleAll(Exception ex)
	{
		return new ResponseEntity<>(
				  new ErrorResponse("InternalServerError", 500),HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
