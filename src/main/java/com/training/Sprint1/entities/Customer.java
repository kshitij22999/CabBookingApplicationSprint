package com.training.Sprint1.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
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
	
	@Enumerated
	private LoginStatus accountStatus;
	
	public List<TripBooking> getTripBookings() {
		return tripBookings;
	}

	public void setTripBookings(List<TripBooking> tripBookings) {
		this.tripBookings = tripBookings;
	}

	public Customer() {
		super();

	}
	public LoginStatus getAccountStatus() {
		return accountStatus;
	}

	public void setAccountStatus(LoginStatus accountStatus) {
		this.accountStatus = accountStatus;
	}

	public Customer(String username, String password, String mobileNumber, String email, Address address) {
		super(username, password, mobileNumber, email, address);
		// TODO Auto-generated constructor stub
	}

	public Customer(Long id, String customerName) {
		super(id);

		this.customerName = customerName;
	}
	public Customer(Long id, String mobileNumber, String email, Address address) {
		super(id, mobileNumber, email, address);
		// TODO Auto-generated constructor stub
	}

	public Customer(Long id, String username, String password, String mobileNumber, String email, Address address) {
		super(id, username, password, mobileNumber, email, address);
		// TODO Auto-generated constructor stub
	}

	public Customer(Long id, String username, String password) {
		super(id, username, password);
		// TODO Auto-generated constructor stub
	}

	public Customer(Long id) {
		super(id);
		// TODO Auto-generated constructor stub
	}

	public Customer(String username, String password) {
		super(username, password);
		// TODO Auto-generated constructor stub
	}

	public Customer(String username) {
		super(username);
		// TODO Auto-generated constructor stub
	}

	public String getCustomerName() {
		return customerName;
	}



	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}


}