package com.training.Sprint1.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.training.Sprint1.entities.TripBooking;

@Service
public interface ITripBookingService {
	public TripBooking addTripBooking(TripBooking tripbooking);
	public TripBooking updateTripBooking(TripBooking tripbooking);
	public TripBooking deleteTripBooking(long tripbookingId);
	public List<TripBooking> getTripsByCustomerId(long customerId);
	public double calculateBill(TripBooking tripbooking);
}
