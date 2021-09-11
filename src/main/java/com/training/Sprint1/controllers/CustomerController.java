package com.training.Sprint1.controllers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
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
import com.training.Sprint1.entities.Driver;
import com.training.Sprint1.entities.TripBooking;
import com.training.Sprint1.exception.CustomerNotFoundException;
import com.training.Sprint1.exception.RoleNotFoundException;
import com.training.Sprint1.service.ICustomerService;
import com.training.Sprint1.service.ITripBookingService;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600,allowedHeaders={"Authorization","Access-Control-Request-Headers","Content-Type","Access-Control-Allow-Origin","Access-Control-Allow-Credentials","Access-Control-Allow-Headers"})
@SuppressWarnings("unused")
@RestController
@RequestMapping("/rest/api")
public class CustomerController {
	final static Logger logger = LoggerFactory.getLogger(CustomerController.class);
	
	@Autowired
	ICustomerService customerService;
	
	@Autowired
	ITripBookingService tripbookingService;

	//Inserting Drivers
	@PostMapping("/customers/insert")
	public ResponseEntity<Customer> insertCustomer(@RequestBody Customer customer) {
		logger.info("Customer is getting inserted using Post Mapping via Customer Controller");
		
		Customer insertedCustomer=customerService.insertCustomer(customer);
		return new ResponseEntity<Customer>(customerService.insertCustomer(insertedCustomer),HttpStatus.OK);
	}

	//Updating Existing Customer
	@PutMapping("/customers/update")
	public ResponseEntity<Customer> updateCustomer(@RequestBody Customer customer) throws CustomerNotFoundException {
		logger.info("Existing Customer is being updated using Put Mapping via Customer Controller");
		
		return new ResponseEntity<Customer>(customerService.updateCustomer(customer), HttpStatus.OK);
	}

	//Deleting Customer
	@DeleteMapping("/customers/delete")
	public ResponseEntity<Customer> deleteCustomer(@RequestBody Customer customer) throws CustomerNotFoundException {
		logger.info("Customer is getting deleted using Delete Mapping via Customer Controller");
		
		return new ResponseEntity<Customer>(customerService.deleteCustomer(customer),HttpStatus.OK);
	}

	//Getting all Customers
	@GetMapping("/customers")
	public ResponseEntity<List<Customer>> viewCustomers() {
		logger.info("Fetching all Customers using Get Mapping via Customer Controller");
		
		return new ResponseEntity<List<Customer>>(customerService.viewCustomers(), HttpStatus.OK);
	}

	//Getting Customer byId
	@GetMapping("/customers/{customerId}")
	public ResponseEntity<Customer> viewCustomer(@PathVariable("customerId")  Long customerId) throws CustomerNotFoundException {
		logger.info("Getting Customer by Id inserted using Get Mapping via Customer Controller");
		
		return new ResponseEntity<Customer>(customerService.viewCustomer(customerId), HttpStatus.OK);
	}
	
	//Adding the trip by using id
	@PostMapping("customers/book/{id}")
	public ResponseEntity<TripBooking> addUnassignedTrip(@PathVariable("id") Long id,@RequestBody TripBooking tripbooking){
		
		logger.info("Adding Unassigned trips by id using Post Mapping via Tripbooking service");
		
		TripBooking trip = tripbookingService.addUnassignedTripBooking(id, tripbooking);
		return new ResponseEntity<TripBooking>(trip,HttpStatus.OK);
	}
	
	//Getting status of Booking by id
	@GetMapping("customers/status/{id}")
	public ResponseEntity<TripBooking> checkStatusOfBooking(@PathVariable("id") Long id){
		logger.info("Getting Staus of Booking for Customer using Get Mapping via Tripbooking service");
		
		TripBooking trip = tripbookingService.getTripBookingById(id);
		return new ResponseEntity<TripBooking>(trip,HttpStatus.OK);
	}
	
	
	@PostMapping("/customers/register")
	public ResponseEntity<Customer> registerCustomer(@RequestBody Customer customer){
		logger.info("Customer is regestering in DB");
		Customer temp=null;
		try {
			temp = customerService.save(customer);
		} catch (RoleNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new ResponseEntity<Customer>(temp,HttpStatus.OK);
	}
	
	@PutMapping("/customers/login")
	public ResponseEntity<Customer> loginCustomer(@RequestBody Customer customer){
		logger.info("Customer is logging in");
		Customer temp = customerService.loginCustomer(customer);
		return new ResponseEntity<Customer>(temp,HttpStatus.OK);
	}
	
	@PutMapping("/customers/logout")
	public ResponseEntity<Customer> logoutCustomer(@RequestBody Customer customer){
		logger.info("Customer is logging out");
		Customer temp = customerService.logoutCustomer(customer);
		return new ResponseEntity<Customer>(temp,HttpStatus.OK);
	}
	
	@GetMapping("/customers/username/{username}")
	public ResponseEntity<Customer> loadCustomerByUsername(@PathVariable("username") String username){
		Customer customer = customerService.getCustomerByUsername(username);
		return new ResponseEntity<Customer>(customer,HttpStatus.OK);
	}
}