package com.training.Sprint1.service;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.transaction.annotation.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import com.training.Sprint1.entities.TripBooking;
import com.training.Sprint1.exception.TripBookingNotFoundException;
import com.training.Sprint1.repository.ICabRepository;
import com.training.Sprint1.repository.ICustomerRepository;
import com.training.Sprint1.repository.IDriverRepository;
import com.training.Sprint1.repository.ITripBookingRepository;

@Service
@Transactional
public class TripBookingService implements ITripBookingService{
	
	@Autowired
	private ITripBookingRepository tripBookingRepo;
	
	
	@Autowired
	private IDriverRepository driverRepository;
	
	@Autowired
	private ICustomerRepository customerRepository;
	
	@Autowired
	private ICabRepository cabRepository;
	
	@Override
	public TripBooking addTripBooking(TripBooking tripbooking) {
		TripBooking newBooking = tripBookingRepo.save(tripbooking);
		return newBooking;
	}

	@Override
	public TripBooking updateTripBooking(TripBooking tripbooking) {
		TripBooking retrievedTripBookingDb = null;
		try {
		retrievedTripBookingDb = tripBookingRepo.findById(tripbooking.getId()).orElseThrow(TripBookingNotFoundException::new);
		}
		catch(Exception e){
			e.printStackTrace();
		}
		retrievedTripBookingDb.setBill(tripbooking.getBill());
		retrievedTripBookingDb.setDistanceInKm(tripbooking.getDistanceInKm());
		retrievedTripBookingDb.setFromDateTime(tripbooking.getFromDateTime());
		retrievedTripBookingDb.setFromLocation(tripbooking.getFromLocation());
		retrievedTripBookingDb.setStatus(tripbooking.getStatus());
		retrievedTripBookingDb.setToDateTime(tripbooking.getToDateTime());
		retrievedTripBookingDb.setToLocation(tripbooking.getFromLocation());
		
		TripBooking updatedBooking = tripBookingRepo.save(retrievedTripBookingDb);
		return updatedBooking;
	}

	@Override
	public TripBooking deleteTripBooking(Long tripbookingId) {
		return null;
	}

	@Override
	public List<TripBooking> getTripsByCustomerId(Long customerID) {
		List<TripBooking> retVal = tripBookingRepo.getTripsByCustomerId(customerID);
		return retVal;
	}

	@Override
	public double calculateBill(TripBooking tripbooking) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<TripBooking> getAllTrips() {
		List<TripBooking> retVal = null;
		retVal = tripBookingRepo.findAll();
		return retVal;
	}

	@Override
	public List<TripBooking> getTripDateWise(LocalDateTime date) {
		// TODO Auto-generated method stub
		return null;
	}

}
