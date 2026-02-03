package com.ecom.notification.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
     
	@ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleAll(Exception ex) {
        return new ResponseEntity<>(
                new ErrorResponse("Notification Service Error", 500),
                HttpStatus.INTERNAL_SERVER_ERROR
        );
    }
}
