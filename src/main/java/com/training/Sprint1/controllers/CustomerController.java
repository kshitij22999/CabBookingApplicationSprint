package com.training.Sprint1.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.training.Sprint1.entities.Customer;
import com.training.Sprint1.exception.CustomerNotFoundException;
//import com.training.Sprint1.exception.InvalidUserOrPasswordException;
import com.training.Sprint1.service.ICustomerService;
//import com.training.Sprint1.service.LoginService;

@RestController
@RequestMapping("/customer")
public class CustomerController {
	@Autowired
	ICustomerService customerService;


	@PostMapping
	public Customer insertCustomer(@RequestBody Customer customer) {
		return customerService.insertCustomer(customer);
	}


	@SuppressWarnings("unused")
	@PutMapping
	public Customer updateCustomer(@RequestBody Customer customer) throws CustomerNotFoundException {
		Customer cViewer = null;
		Customer c = null;
		try {
			cViewer = viewCustomer(customer.getId());
			c = customerService.updateCustomer(customer);
		} catch (Exception e) {
			throw new CustomerNotFoundException("Customer Not Found to perform Update Operation!");
		}
		return c;
	}


	@SuppressWarnings("unused")
	@DeleteMapping
	public Customer deleteCustomer(Customer customer) throws CustomerNotFoundException {
		Customer cViewer = null;
		Customer c = null;
		try {
			cViewer = viewCustomer(customer.getId());
			c = customerService.deleteCustomer(customer);
		} catch (Exception e) {
			throw new CustomerNotFoundException("Customer Not Found to perform Delete Operation!");
		}
		return c;
	}


	@GetMapping(value = "all")
	public List<Customer> viewCustomers() {
		return customerService.viewCustomers();
	}


	@GetMapping(value = "/{customerId}")
	public Customer viewCustomer(@PathVariable Long long1) throws CustomerNotFoundException {
		Customer c = null;
		try {
			c = customerService.viewCustomer(long1);
		} catch (Exception e) {
			throw new CustomerNotFoundException("Customer with Id: " + long1 + " Not Found!");
		}
		return c;
	}
}
