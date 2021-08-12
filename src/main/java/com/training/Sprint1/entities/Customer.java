package com.training.Sprint1.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name="cba_customer")
@Entity
public class Customer extends User {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int customerId;

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public Customer() {

	}

	public Customer(int customerId) {
		super();
		this.customerId = customerId;
	}
	public Customer(String username, String password, String mobileNumber, String email, String address) {
		super(username, password, mobileNumber, email, address);
		// TODO Auto-generated constructor stub
	}
}
