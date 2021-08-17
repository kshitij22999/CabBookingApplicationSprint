package com.training.Sprint1.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.training.Sprint1.entities.Customer;
import com.training.Sprint1.exception.CustomerNotFoundException;
//import com.training.Sprint1.exception.InvalidUserOrPasswordException;
import com.training.Sprint1.service.ICustomerService;
//import com.training.Sprint1.service.LoginService;

@SuppressWarnings("unused")
@RestController
@RequestMapping("/rest/api")
public class CustomerController {
	@Autowired
	ICustomerService customerService;


	@PostMapping("/customers/insert")
	public ResponseEntity<Customer> insertCustomer(@RequestBody Customer customer) {
		Customer insertedCustomer=customerService.insertCustomer(customer);
		return new ResponseEntity<Customer>(customerService.insertCustomer(insertedCustomer),HttpStatus.OK);
	}


	@PutMapping("/customers/update")
	public ResponseEntity<Customer> updateCustomer(@RequestBody Customer customer) throws CustomerNotFoundException {
		return new ResponseEntity<Customer>(customerService.updateCustomer(customer), HttpStatus.OK);
	}


	@DeleteMapping("/customers/delete")
	public ResponseEntity<Customer> deleteCustomer(@RequestBody Customer customer) throws CustomerNotFoundException {
		return new ResponseEntity<Customer>(customerService.deleteCustomer(customer),HttpStatus.OK);
	}


	@GetMapping("/customers")
	public ResponseEntity<List<Customer>> viewCustomers() {
		return new ResponseEntity<List<Customer>>(customerService.viewCustomers(), HttpStatus.OK);
	}


	@GetMapping("/customers/{customerId}")
	public ResponseEntity<Customer> viewCustomer(@PathVariable("customerId")  Long customerId) throws CustomerNotFoundException {
		return new ResponseEntity<Customer>(customerService.viewCustomer(customerId), HttpStatus.OK);
	}
}
