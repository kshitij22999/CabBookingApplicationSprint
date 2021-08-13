package com.training.Sprint1.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.training.Sprint1.entities.Customer;
import com.training.Sprint1.exception.CustomerNotFoundException;

@Service
public interface ICustomerService {
	public Customer insertCustomer(Customer customer);

	public Customer updateCustomer(Customer customer) throws CustomerNotFoundException;

	public Customer deleteCustomer(Customer customer)throws CustomerNotFoundException;

	public List<Customer> viewCustomers();

	public Customer viewCustomer(int customerId) throws CustomerNotFoundException;

	public Customer validateCustomer(String username, String password) throws CustomerNotFoundException;
}
