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
	private String address;
	
	private String city;
	
	private String country;
	
	private String pincode;
	
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
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

	public Address(String address, String city, String country, String pincode) {
		super();
		this.address = address;
		this.city = city;
		this.country = country;
		this.pincode = pincode;
	}
	
}
