package com.training.Sprint1.exception;



@SuppressWarnings("serial")
public class TripBookingNotFoundException extends Exception{


	
	
	private String msg;

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	@Override
	public String toString() {
		return "TripBookingNotFoundException [msg=" + msg + "]";
	}

	public TripBookingNotFoundException(String msg) {
		super();
		this.msg = msg;
	}

	public TripBookingNotFoundException() {
		super();
	}

}
