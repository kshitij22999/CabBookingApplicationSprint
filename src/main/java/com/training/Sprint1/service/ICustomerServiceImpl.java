package com.training.Sprint1.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.training.Sprint1.entities.Customer;
import com.training.Sprint1.exception.CustomerNotFoundException;
import com.training.Sprint1.repository.ICustomerRepository;

@Service("customerService")
public abstract class ICustomerServiceImpl implements ICustomerService {
	@Autowired
	ICustomerRepository cRepo;

	

	@Override
	public Customer insertCustomer(Customer customer) {
		cRepo.saveAndFlush(customer);
		return customer;
	}

	@Override
	public Customer updateCustomer(Customer customer) throws CustomerNotFoundException{
		Customer cus = cRepo.findById(customer.getId()).get();
		if (cus != null) {
			cus.setEmail(customer.getEmail());
			cus.setMobileNumber(customer.getMobileNumber());
			cus.setUsername(customer.getUsername());
			cus.setPassword(customer.getPassword());
			cus.setAddress(customer.getAddress());
			cRepo.save(cus);
		}
		return cus;
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