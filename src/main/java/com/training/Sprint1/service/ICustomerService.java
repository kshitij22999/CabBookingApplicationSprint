package com.training.Sprint1.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.training.Sprint1.entities.Customer;
import com.training.Sprint1.exception.CustomerNotFoundException;
import com.training.Sprint1.exception.RoleNotFoundException;

@Service
public interface ICustomerService {
	public Customer insertCustomer(Customer customer);

	public Customer updateCustomer(Customer customer) throws CustomerNotFoundException;

	public Customer deleteCustomer(Customer customer)throws CustomerNotFoundException;

	public List<Customer> viewCustomers();

	Customer viewCustomer(Long customerId) throws CustomerNotFoundException;
	
	public Customer registerCustomer(Customer customer);
	
	public Customer loginCustomer(Customer customer);
	
	public Customer logoutCustomer(Customer customer);

	Customer save(Customer user) throws RoleNotFoundException;
}