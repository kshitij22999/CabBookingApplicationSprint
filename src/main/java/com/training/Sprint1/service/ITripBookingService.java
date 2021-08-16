package com.training.Sprint1.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.training.Sprint1.entities.TripBooking;

<<<<<<< HEAD
@SuppressWarnings("unused")
=======
>>>>>>> 3f78c0ae3dea4d2a27cc58bc35e07772819557f4
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
<<<<<<< HEAD
=======
	Float getDistanceInKm(TripBooking tripbooking);
>>>>>>> 3f78c0ae3dea4d2a27cc58bc35e07772819557f4
}
