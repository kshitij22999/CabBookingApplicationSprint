package com.training.Sprint1.service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.tomcat.util.net.Acceptor.AcceptorState;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.training.Sprint1.entities.Customer;
import com.training.Sprint1.entities.LoginStatus;
import com.training.Sprint1.entities.Role;
import com.training.Sprint1.entities.User;
import com.training.Sprint1.exception.CustomerNotFoundException;
import com.training.Sprint1.exception.InvalidCredentials;
import com.training.Sprint1.exception.RoleNotFoundException;
import com.training.Sprint1.repository.ICustomerRepository;

@SuppressWarnings("unused")
@Service("customerService")
public class ICustomerServiceImpl implements ICustomerService {
	@Autowired
	ICustomerRepository cRepo;
	
	@Autowired
	RoleService roleService;
	
	@Autowired
	private BCryptPasswordEncoder bcryptEncoder;


	

	@Override
	public Customer insertCustomer(Customer customer) {
		Customer insertedCustomer=cRepo.save(customer);
		return insertedCustomer;
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

		List<Customer> list= cRepo.findAll();
		return list;
	}
	
	@Override
	public Customer viewCustomer(Long customerId)throws CustomerNotFoundException {
		Customer cust=null;
		try {
			cust = cRepo.findById(customerId).orElseThrow(CustomerNotFoundException::new);
		} catch (CustomerNotFoundException e) {
			e.printStackTrace();
		}
		return cust;
	}

	

	@Override
	public Customer registerCustomer(Customer customer) {
		customer.setAccountStatus(LoginStatus.LOGGEDOUT);
		Customer insertedCustomer=cRepo.save(customer);
		return insertedCustomer;
	}

	@Override
	public Customer loginCustomer(Customer customer) {
		Customer retCust=null;
		try {
			retCust = cRepo.findById(customer.getId()).orElseThrow(CustomerNotFoundException::new);
			if(retCust.getUsername().equals(customer.getUsername()) && retCust.getPassword().equals(customer.getPassword())) {
				retCust.setAccountStatus(LoginStatus.LOGGEDIN);
				retCust = cRepo.save(retCust);
			}else {
				throw new InvalidCredentials("Wrong credentials");
			}
		} catch (CustomerNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch(InvalidCredentials i) {
			i.printStackTrace();
		}
		return retCust;
	}

	@Override
	public Customer logoutCustomer(Customer customer) {
		Customer retCust=null;
		try {
			retCust = cRepo.findById(customer.getId()).orElseThrow(CustomerNotFoundException::new);
			retCust.setAccountStatus(LoginStatus.LOGGEDOUT);
			retCust = cRepo.save(retCust);
		} catch (CustomerNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return retCust;
	}
	
	@Override
    public Customer save(Customer user) throws RoleNotFoundException {
	    Customer newUser = new Customer();
	    newUser.setUsername(user.getUsername());
	    newUser.setPassword(bcryptEncoder.encode(user.getPassword()));
	    Set<Role> roles= user.getRoles();
	    Set<Role> newSetOfRoles =  new HashSet<Role>();
	    
	    for(Role r:roles) {
	    	
	    	newSetOfRoles.add(roleService.findRoleById(r.getId()));
	    }
	    newUser.setRoles(newSetOfRoles);
	    
	    System.out.println(newSetOfRoles+"************************");
		  Customer savedUser = cRepo.save(user);
		  System.out.println(savedUser+"**************************");
		  return savedUser;
	}

	
	
}
