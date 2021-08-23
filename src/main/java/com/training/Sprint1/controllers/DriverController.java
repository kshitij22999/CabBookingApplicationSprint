package com.training.Sprint1.controllers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.training.Sprint1.entities.Driver;
import com.training.Sprint1.entities.TripBooking;
import com.training.Sprint1.exception.DriverDoesNotExistException;
import com.training.Sprint1.service.IDriverService;
import com.training.Sprint1.service.ITripBookingService;

@Controller
@RequestMapping("/rest/api")
public class DriverController {

	final static Logger logger = LoggerFactory.getLogger(DriverController.class);
	
	@Autowired
	IDriverService driverService;
	
	@Autowired
	ITripBookingService tripbookingService;
	
	
	
	//Adding Drivers 
	@PostMapping("/drivers")
	public ResponseEntity<Driver> addDriver(@RequestBody Driver driver){
		logger.info("Driver is getting added using Post Mapping via Driver Controller");
		
		Driver addedDriver = driverService.addDriver(driver);
		return new ResponseEntity<Driver>(driverService.addDriver(addedDriver),HttpStatus.OK);
		
	}
	
	//Getting Driver by Id
	@GetMapping("/drivers/{id}")
	public ResponseEntity<Driver> getDriverById(@PathVariable("id") Long id) throws DriverDoesNotExistException{
		logger.info("Getting Driver by id using Get Mapping via Driver Controller");
		
		return new ResponseEntity<Driver>(driverService.getDriverById(id), HttpStatus.OK);
	}
	
	//Getting All Drivers
	@GetMapping("/drivers")
	public ResponseEntity <List<Driver>>getAllDrivers(){
		logger.info("Fetching all Drivers using Get Mapping via Driver Controller ");
		
		return new ResponseEntity<List<Driver>>(driverService.getAllDrivers(), HttpStatus.OK);
	}
	
	//Updating Existing Driver
	@PutMapping("/drivers/update")
	public ResponseEntity<Driver> updateDriver(@RequestBody Driver driver) throws DriverDoesNotExistException{
		logger.info("Existing Driver is being updated using Put Mapping via Driver Controller");
		
		return new ResponseEntity<Driver>(driverService.updateDriver(driver), HttpStatus.OK);
	}
	
	//Deleting Driver
	@DeleteMapping("/drivers/{id}")
	public ResponseEntity<Driver> deleteDriver(@PathVariable Long id) throws DriverDoesNotExistException{
		logger.info("Driver is getting deleted using Delete Mapping via Driver Controller");
		
		return new ResponseEntity<Driver>(driverService.deleteDriver(id), HttpStatus.OK);
	}
	
	//Getting Best Drivers
	@GetMapping("/drivers/best")
	public ResponseEntity<List<Driver>> getBestDrivers(){
		logger.info("All Drivers having rating >=4.5 are being fetched using Get Mapping via Driver Controller");
		
	List<Driver> bestDrivers = driverService.getBestDrivers();
	return new ResponseEntity<List<Driver>>(bestDrivers,HttpStatus.OK);
	}
	
	//Getting Bad Drivers
		@GetMapping("/drivers/bad")
		public ResponseEntity<List<Driver>> getBadDrivers(){
			logger.info("All Drivers having rating <= 3 are being fetched using Get Mapping via Driver Controller");
			
		List<Driver> badDrivers = driverService.getBadDrivers();
		return new ResponseEntity<List<Driver>>(badDrivers,HttpStatus.OK);
		}
	
	//Accepting 
	@PutMapping("/drivers/accept/{id}")
	public ResponseEntity<TripBooking> acceptBooking(@PathVariable("id") Long id,@RequestBody Driver driver){
		logger.info("Driver can accept the available trip bookings using Put Mapping via Driver Service");
		
		TripBooking trip = driverService.acceptBooking(id,driver);
		return new ResponseEntity<TripBooking>(trip,HttpStatus.OK);
	}
	
	@PostMapping("/drivers/register")
	public ResponseEntity<Driver> registerDriver(@RequestBody Driver driver){
		logger.info("New driver is registered");
		Driver temp = driverService.registerDriver(driver);
		return new ResponseEntity<Driver>(temp,HttpStatus.OK);
	}
	
	@PutMapping("/drivers/login")
	public ResponseEntity<Driver> loginDriver(@RequestBody Driver driver){
		logger.info("Driver is logging in.");
		Driver temp = driverService.loginDriver(driver);
		return new ResponseEntity<Driver>(temp,HttpStatus.OK);
	}
	
	@PutMapping("/drivers/logout")
	public ResponseEntity<Driver> logoutDriver(@RequestBody Driver driver){
		logger.info("Driver is logging out.");
		Driver temp = driverService.logoutDriver(driver);
		return new ResponseEntity<Driver>(temp,HttpStatus.OK);
	}
	
	@GetMapping("/drivers/bad")
	public ResponseEntity<List<Driver>> getBadDrivers(){
		logger.info("All Drivers having rating <= 3 are being fetched using Get Mapping via Driver Controller");
		
	List<Driver> badDrivers = driverService.getBadDrivers();
	return new ResponseEntity<List<Driver>>(badDrivers,HttpStatus.OK);
	}
	

}
