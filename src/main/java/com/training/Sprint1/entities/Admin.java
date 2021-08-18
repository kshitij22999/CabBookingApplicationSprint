package com.training.Sprint1.entities;

import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.Table;
import com.training.Sprint1.entities.User;

@SuppressWarnings("unused")
@Entity
@Table(name="cba_admin5")
public class Admin extends User{
	
	@Enumerated
	private LoginStatus accountStatus;
	
	public Admin(Long id, String username, String password, LoginStatus accountStatus) {
		super(id, username, password);
		this.accountStatus = accountStatus;
	}

	public Admin(String username, String password, LoginStatus accountStatus) {
		super(username, password);
		this.accountStatus = accountStatus;
	}

	public Admin(String username, String password) {
		super(username, password);
	}

	public LoginStatus getAccountStatus() {
		return accountStatus;
	}

	public void setAccountStatus(LoginStatus accountStatus) {
		this.accountStatus = accountStatus;
	}

	public Admin(long id, String username, String password, String mobileNumber, String email, Address address) {
		super(id, username, password, mobileNumber, email, address);
		// TODO Auto-generated constructor stub
	}

	public Admin() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Admin(long id, String username) {
		super(id, username);
		// TODO Auto-generated constructor stub
	}

	public Admin(String username, String password, String mobileNumber, String email, Address address) {
		super(username, password, mobileNumber, email, address);
		// TODO Auto-generated constructor stub
	}

}
