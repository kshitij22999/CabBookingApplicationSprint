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
	private int customerName;
	
	public Customer() {
		super();
	}

	public Customer(int customerId, int customerName) {
		super();
		this.customerId = customerId;
		this.customerName = customerName;
	}



	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public int getCustomerName() {
		return customerName;
	}



	public void setCustomerName(int customerName) {
		this.customerName = customerName;
	}

	
}
