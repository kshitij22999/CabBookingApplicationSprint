package com.training.Sprint1.controllers;

import java.util.List;


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

	@Autowired
	IDriverService service;
	
	@Autowired
	ITripBookingService tripbookingService;
	
	@PostMapping("/drivers")
	public ResponseEntity<Driver> addDriver(@RequestBody Driver driver){
		Driver addedDriver = service.addDriver(driver);
		return new ResponseEntity<Driver>(service.addDriver(addedDriver),HttpStatus.OK);
		
	}
	
	@GetMapping("/drivers/{id}")
	public ResponseEntity<Driver> getDriverById(@PathVariable("id") Long id) throws DriverDoesNotExistException{
		return new ResponseEntity<Driver>(service.getDriverById(id), HttpStatus.OK);
	}
	
	@GetMapping("/drivers")
	public ResponseEntity <List<Driver>>getAllDrivers(){
		
		return new ResponseEntity<List<Driver>>(service.getAllDrivers(), HttpStatus.OK);
	}
	
	@PostMapping("/drivers/update")
	public ResponseEntity<Driver> updateDriver(@RequestBody Driver driver) throws DriverDoesNotExistException{
		return new ResponseEntity<Driver>(service.updateDriver(driver), HttpStatus.OK);
	}
	
	
	@DeleteMapping("/drivers/{id}")
	public ResponseEntity<Driver> deleteDriver(@RequestBody Driver driver) throws DriverDoesNotExistException{
		return new ResponseEntity<Driver>(service.deleteDriver(driver), HttpStatus.OK);
	}
	
	@GetMapping("/drivers/best")
	public ResponseEntity<List<Driver>> getBestDrivers(){
	List<Driver> bestDrivers = service.getBestDrivers();
	return new ResponseEntity<List<Driver>>(bestDrivers,HttpStatus.OK);
	}
	
	@PutMapping("/drivers/accept/{id}")
	public ResponseEntity<TripBooking> acceptBooking(@PathVariable("id") Long id,@RequestBody Driver driver){
		TripBooking trip = service.acceptBooking(id,driver);
		return new ResponseEntity<TripBooking>(trip,HttpStatus.OK);
	}
	

}
