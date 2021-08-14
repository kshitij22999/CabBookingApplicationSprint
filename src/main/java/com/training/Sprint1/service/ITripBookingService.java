package com.training.Sprint1.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.training.Sprint1.entities.TripBooking;

@Service
@Transactional
public interface ITripBookingService {
	public TripBooking addTripBooking(TripBooking tripbooking);
	public TripBooking updateTripBooking(TripBooking tripbooking);
	public TripBooking deleteTripBooking(Long tripbookingId);
	public TripBooking calculateBill(TripBooking tripbooking);
	public List<TripBooking> getAllTrips();
	public List<TripBooking> getTripDateWise(LocalDateTime date);
	List<TripBooking> getTripsByCustomerId(Long customerID);
	Float getDistanceInKm(TripBooking tripbooking);
}
