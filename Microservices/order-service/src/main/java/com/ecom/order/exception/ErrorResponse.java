package com.ecom.order.exception;

import java.time.LocalDateTime;

public class ErrorResponse {
    private String message;
    private int status;
    private LocalDateTime time = LocalDateTime.now();

    public ErrorResponse(String message, int status) {
        this.message = message;
        this.status = status;
    }

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public LocalDateTime getTime() {
		return time;
	}

	public void setTime(LocalDateTime time) {
		this.time = time;
	}
    
    
}

