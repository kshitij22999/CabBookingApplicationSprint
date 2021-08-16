package com.training.Sprint1.exception;

<<<<<<< HEAD
@SuppressWarnings("serial")
public class TripBookingNotFoundException extends Exception {
=======
public class TripBookingNotFoundException extends Exception{
>>>>>>> 3f78c0ae3dea4d2a27cc58bc35e07772819557f4
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
<<<<<<< HEAD
=======
	
>>>>>>> 3f78c0ae3dea4d2a27cc58bc35e07772819557f4
}
