package com.training.Sprint1.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.training.Sprint1.entities.Customer;
import com.training.Sprint1.entities.TripBooking;


@Service
@Transactional
public interface ITripBookingService {
	public TripBooking addTripBooking(TripBooking tripbooking);
	public TripBooking updateTripBooking(TripBooking tripbooking);
	public TripBooking deleteTripBooking(Long tripbookingId);
	public Float calculateBill(TripBooking tripbooking);
	public List<TripBooking> getAllTrips();
	public List<TripBooking> getTripDateWise(LocalDateTime date);
	public TripBooking addUnassignedTripBooking(Long id,TripBooking tripBooking);
	List<TripBooking> getTripsByCustomer(Customer customer);
	Float getDistanceInKm(TripBooking tripbooking);
	TripBooking getTripBookingById(Long id);
	public List<TripBooking> getNotAllocatedList();
	TripBooking endTrip(Long id);

}
