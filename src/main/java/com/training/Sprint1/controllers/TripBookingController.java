package com.training.Sprint1.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.training.Sprint1.entities.TripBooking;
import com.training.Sprint1.exception.TripBookingNotFoundException;
import com.training.Sprint1.service.ITripBookingService;

@Controller
@RequestMapping("rest/api")
public class TripBookingController {
	
	@Autowired
	ITripBookingService tripbookingService;
	
	@GetMapping("tripbookings/{id}")
	public ResponseEntity<TripBooking> getTripBookingById(@RequestParam Long id) throws TripBookingNotFoundException{
		return new ResponseEntity<TripBooking>(tripbookingService.getTripBookingById(id),HttpStatus.OK);
	}
	
	@PostMapping("tripbookings/")
	public ResponseEntity<TripBooking> addTripBooking(@RequestParam TripBooking tripbooking){
		TripBooking newVal = tripbookingService.addTripBooking(tripbooking);
		return new ResponseEntity<TripBooking>(newVal,HttpStatus.OK);
	}
	
	@PutMapping("tripbooings/update")
	public ResponseEntity<TripBooking> updateTripBooking(@RequestParam TripBooking tripbooking){
		TripBooking newVal = tripbookingService.updateTripBooking(tripbooking);
		return new ResponseEntity<TripBooking>(newVal,HttpStatus.OK);
	}
	
}
