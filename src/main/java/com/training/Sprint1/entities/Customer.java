package com.training.Sprint1.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@SuppressWarnings("unused")
@Table(name="cba_customer5")
@Entity
public class Customer extends User {

private String customerName;
	
	@OneToMany(cascade = CascadeType.ALL,targetEntity = TripBooking.class)
	@JoinColumn(referencedColumnName="id")
	private List<TripBooking> tripBookings;
	
	public List<TripBooking> getTripBookings() {
		return tripBookings;
	}

	public void setTripBookings(List<TripBooking> tripBookings) {
		this.tripBookings = tripBookings;
	}

	public Customer() {
		super();

	}

	public Customer(String username, String password, String mobileNumber, String email, Address address) {
		super(username, password, mobileNumber, email, address);
		// TODO Auto-generated constructor stub
	}

	public Customer(Long id, String customerName) {
		super(id);

		this.customerName = customerName;
	}
	public String getCustomerName() {
		return customerName;
	}



	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}


}