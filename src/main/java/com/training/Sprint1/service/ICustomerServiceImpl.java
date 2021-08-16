package com.training.Sprint1.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.training.Sprint1.entities.Customer;
import com.training.Sprint1.exception.CustomerNotFoundException;
import com.training.Sprint1.repository.ICustomerRepository;

@Service("customerService")
public class ICustomerServiceImpl implements ICustomerService {
	@Autowired
	ICustomerRepository cRepo;

	

	@Override
	public Customer insertCustomer(Customer customer) {
		cRepo.saveAndFlush(customer);
		return customer;
	}

	@Override
	public Customer updateCustomer(Customer customer){
		Customer updatedCustomer = null;
		try {
			updatedCustomer= cRepo.findById(customer.getId()).orElseThrow(CustomerNotFoundException::new);
		} catch (CustomerNotFoundException e) {
			
			e.printStackTrace();
		}
		updatedCustomer.setEmail(updatedCustomer.getEmail());
		updatedCustomer.setMobileNumber(updatedCustomer.getMobileNumber());
		updatedCustomer.setUsername(updatedCustomer.getUsername());
		updatedCustomer.setPassword(updatedCustomer.getPassword());
		updatedCustomer.setAddress(updatedCustomer.getAddress());
		
		Customer cust = cRepo.save(updatedCustomer);
		return cust;
	}

	
	@Override
	public Customer deleteCustomer(Customer customer)throws CustomerNotFoundException {
		cRepo.delete(customer);
		return customer;
	}


	@Override
	public List<Customer> viewCustomers() {

		return cRepo.findAll();
	}
	
	@Override
	public Customer viewCustomer(Long customerId)throws CustomerNotFoundException {
		return cRepo.findById(customerId).get();
	}

	@Override
	public Customer validateCustomer(String username, String password)throws CustomerNotFoundException {

		return null;
	}

	
	
}
