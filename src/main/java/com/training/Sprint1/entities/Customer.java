package com.training.Sprint1.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name="cba_customer")
@Entity
public class Customer extends User {
	
	private String customerName;
	
	public Customer() {
		super();
	}

	public Customer(Long customerId, String customerName) {
		super(customerId);

		this.customerName = customerName;
	}





	public String getCustomerName() {
		return customerName;
	}



	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	
}
