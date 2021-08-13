package com.training.Sprint1.service;

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
	public TripBooking deleteTripBooking(long tripbookingId) {
		return null;
	}

	@Override
	//@Query(value="SELECT tb FROM TripBooking t WHERE t.getCustomer().getCustomerId()=:customerId")
	public List<TripBooking> getTripsByCustomerId(@Param("customerId") long customerId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public double calculateBill(TripBooking tripbooking) {
		// TODO Auto-generated method stub
		return 0;
	}

}
