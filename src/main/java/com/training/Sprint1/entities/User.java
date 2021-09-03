package com.training.Sprint1.entities;
import java.util.Set;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Table(name="cba_userdemo")
public class User{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String username;
	private String password;
	private String mobileNumber;
	private String email;
	@Embedded
	private Address address;
	
	 @ManyToMany(fetch = FetchType.EAGER)
	 @JoinTable(name = "proj_user_rolesdemo", joinColumns = {
	            @JoinColumn(name = "USER_ID") }, inverseJoinColumns = {
	            @JoinColumn(name = "ROLE_ID") })
	 private Set<Role> roles;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}
	
	
	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

	public User() {
		super();
	}

	public User(String username, String password, String mobileNumber, String email, Address address) {
		super();
		this.username = username;
		this.password = password;
		this.mobileNumber = mobileNumber;
		this.email = email;
		this.setAddress(address);
	}

	public User(String username) {
		super();
		this.username = username;
	}


	public User(Long id, String username, String password, String mobileNumber, String email, Address address) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.mobileNumber = mobileNumber;
		this.email = email;
		this.address = address;

	}

	public User(Long id, String username, String password) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
	}


	public User(Long id, String mobileNumber, String email, Address address) {
		super();
		this.id = id;
		this.mobileNumber = mobileNumber;
		this.email = email;
		this.address = address;

	}

	public User(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}

	public User(Long id, String username) {
		super();
		this.id = id;
		this.username = username;
	}

	public User(Long id) {
		super();
		this.id = id;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", password=" + password + ", mobileNumber=" + mobileNumber
				+ ", email=" + email + ", address=" + address + ", roles=" + roles + "]";
	}

	


}