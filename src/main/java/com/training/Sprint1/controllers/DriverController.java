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
import org.springframework.web.bind.annotation.RequestParam;

import com.training.Sprint1.entities.Driver;
import com.training.Sprint1.entities.TripBooking;
import com.training.Sprint1.exception.DriverDoesNotExistException;
import com.training.Sprint1.service.IDriverService;
import com.training.Sprint1.service.ITripBookingService;

@Controller
@RequestMapping("/rest/api")
public class DriverController {

	
	@Autowired
	IDriverService driverService;
	
	@Autowired
	ITripBookingService tripbookingService;
	
	@PostMapping("/drivers")
	public ResponseEntity<Driver> addDriver(@RequestBody Driver driver){
		Driver addedDriver = driverService.addDriver(driver);
		return new ResponseEntity<Driver>(driverService.addDriver(addedDriver),HttpStatus.OK);
		
	}
	
	@GetMapping("/drivers/{id}")
	public ResponseEntity<Driver> getDriverById(@PathVariable("id") Long id) throws DriverDoesNotExistException{
		return new ResponseEntity<Driver>(driverService.getDriverById(id), HttpStatus.OK);
	}
	
	@GetMapping("/drivers")
	public ResponseEntity <List<Driver>>getAllDrivers(){
		
		return new ResponseEntity<List<Driver>>(driverService.getAllDrivers(), HttpStatus.OK);
	}
	
	@PutMapping("/drivers/update")
	public ResponseEntity<Driver> updateDriver(@RequestBody Driver driver) throws DriverDoesNotExistException{
		return new ResponseEntity<Driver>(driverService.updateDriver(driver), HttpStatus.OK);
	}
	
	
	@DeleteMapping("/drivers/{id}")
	public ResponseEntity<Driver> deleteDriver(@RequestParam Long id) throws DriverDoesNotExistException{
		return new ResponseEntity<Driver>(driverService.deleteDriver(id), HttpStatus.OK);
	}
	
	@GetMapping("/drivers/best")
	public ResponseEntity<List<Driver>> getBestDrivers(){
	List<Driver> bestDrivers = driverService.getBestDrivers();
	return new ResponseEntity<List<Driver>>(bestDrivers,HttpStatus.OK);
	}
	
	@PutMapping("/drivers/accept/{id}")
	public ResponseEntity<TripBooking> acceptBooking(@PathVariable("id") Long id,@RequestBody Driver driver){
		TripBooking trip = driverService.acceptBooking(id,driver);
		return new ResponseEntity<TripBooking>(trip,HttpStatus.OK);
	}
	

}
