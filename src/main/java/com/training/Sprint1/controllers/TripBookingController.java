package com.training.Sprint1.controllers;

import java.util.List;

import javax.websocket.server.PathParam;

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

import com.training.Sprint1.entities.Customer;
import com.training.Sprint1.entities.Status;
import com.training.Sprint1.entities.TripBooking;
import com.training.Sprint1.exception.CustomerNotFoundException;
import com.training.Sprint1.exception.TripBookingNotFoundException;
import com.training.Sprint1.repository.ICustomerRepository;
import com.training.Sprint1.service.ICustomerService;
import com.training.Sprint1.service.ITripBookingService;

@Controller
@RequestMapping("rest/api")
public class TripBookingController {
	
	@Autowired
	ITripBookingService tripbookingService;
	
	@Autowired
	ICustomerService customerService;
	
	
	
	@GetMapping("/tripbookings/{id}")
	public ResponseEntity<TripBooking> getTripBookingById(@PathVariable("id") Long id) throws TripBookingNotFoundException{
		return new ResponseEntity<TripBooking>(tripbookingService.getTripBookingById(id),HttpStatus.OK);
	}
	
	
	
	@PostMapping("/tripbookings")
	public ResponseEntity<TripBooking> addTripBooking(@RequestBody TripBooking tripbooking){
		TripBooking newVal = tripbookingService.addTripBooking(tripbooking);
		return new ResponseEntity<TripBooking>(newVal,HttpStatus.OK);
	}
	
	@PutMapping("/tripbooings/update")
	public ResponseEntity<TripBooking> updateTripBooking(@RequestBody TripBooking tripbooking){
		TripBooking newVal = tripbookingService.updateTripBooking(tripbooking);
		return new ResponseEntity<TripBooking>(newVal,HttpStatus.OK);
	}
	
	@GetMapping("/tripbookings")
	public ResponseEntity<List<TripBooking>> listAllBookings(){
		List<TripBooking> lstBooking = tripbookingService.getAllTrips();
		return new ResponseEntity<List<TripBooking>>(lstBooking,HttpStatus.OK);
	}
	
	
	
	@DeleteMapping("/tripbookings/{id}")
	public ResponseEntity<TripBooking> deleteTripBooking(@PathVariable("id") Long id){
		TripBooking trip = tripbookingService.deleteTripBooking(id);
		return new ResponseEntity<TripBooking>(trip,HttpStatus.OK);
		
	}
	
}
