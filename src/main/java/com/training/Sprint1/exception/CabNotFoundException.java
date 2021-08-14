package com.training.Sprint1.exception;

public class CabNotFoundException  extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = -9090587718141879101L;
	private String message;
	
	public String getMessage() {
		return message;
		
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public CabNotFoundException() {
		// TODO Auto-generated constructor stub
	}

	public CabNotFoundException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public CabNotFoundException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

	public CabNotFoundException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}
	public CabNotFoundException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

}
