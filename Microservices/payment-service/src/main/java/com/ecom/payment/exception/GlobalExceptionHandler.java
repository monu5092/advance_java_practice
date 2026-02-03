package com.ecom.payment.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
      
	    @ExceptionHandler(PaymentFailedException.class)
	    public ResponseEntity<ErrorResponse> handlePaymentFailed(PaymentFailedException ex)
	    {
	    	return new ResponseEntity<>(
	    			 new ErrorResponse(ex.getMessage(), 400),
	    			 HttpStatus.BAD_REQUEST
	    			 );
	    }
	    
	    @ExceptionHandler(Exception.class)
	    public ResponseEntity<ErrorResponse> handleAll(Exception ex)
	    { 
	    	return new ResponseEntity<>(
	    			  new ErrorResponse("Internal Server Error", 500),
	    			  HttpStatus.INTERNAL_SERVER_ERROR
	    			);
	    	
	    }
	    
}
