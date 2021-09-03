package com.training.Sprint1.exception;

public class RoleNotFoundException extends Exception {
	private String message;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "RoleNotFoundException [message=" + message + "]";
	}

	public RoleNotFoundException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public RoleNotFoundException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	public RoleNotFoundException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public RoleNotFoundException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public RoleNotFoundException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}
	
}
