package com.example.demo.exceptions;

import java.time.LocalDateTime;

public class ErrorDetails {
	private LocalDateTime time;
	private String message;
	private String details;
	public ErrorDetails(LocalDateTime time, String message, String details) {
		super();
		this.time = time;
		this.message = message;
		this.details = details;
	}
	public LocalDateTime getTime() {
		return time;
	}
	public String getMessage() {
		return message;
	}
	public String getDetails() {
		return details;
	}
	

}
