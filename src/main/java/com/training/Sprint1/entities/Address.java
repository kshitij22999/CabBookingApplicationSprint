package com.training.Sprint1.entities;

import javax.persistence.CascadeType;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@SuppressWarnings("unused")
@Embeddable
public class Address{
	private String addr;
	
	
	
	private String city;
	
	private String state;
	
	private String pincode;
	
	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getPincode() {
		return pincode;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}
	public Address() {
		super();
	}

	public Address(String addr, String city, String state, String pincode) {
		super();
		this.addr = addr;
		this.city = city;
		this.state = state;
		this.pincode = pincode;
	}
	
}

