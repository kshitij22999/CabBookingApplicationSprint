package com.training.Sprint1.entities;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.training.Sprint1.entities.User;

@Entity
@Table(name="cba_admin")
public class Admin extends User{

	public Admin() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Admin(long id, String username) {
		super(id, username);
		// TODO Auto-generated constructor stub
	}

	public Admin(String username, String password, String mobileNumber, String email, String address) {
		super(username, password, mobileNumber, email, address);
		// TODO Auto-generated constructor stub
	}

	public Admin(String username) {
		super(username);
		// TODO Auto-generated constructor stub
	}
	

}
