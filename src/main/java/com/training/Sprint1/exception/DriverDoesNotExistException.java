
package com.training.Sprint1.exception;

@SuppressWarnings("serial")
public class DriverDoesNotExistException extends Exception {
	private String message;
	
	
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public DriverDoesNotExistException() {
		// TODO Auto-generated constructor stub
	}

	public DriverDoesNotExistException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public DriverDoesNotExistException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

	public DriverDoesNotExistException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public DriverDoesNotExistException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}
}

