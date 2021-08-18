package com.training.Sprint1.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.transaction.annotation.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import com.training.Sprint1.entities.Cab;
import com.training.Sprint1.entities.CarType;
import com.training.Sprint1.entities.Customer;
import com.training.Sprint1.entities.Driver;
import com.training.Sprint1.entities.Status;
import com.training.Sprint1.entities.TripBooking;
import com.training.Sprint1.entities.VaccinationStatus;
import com.training.Sprint1.exception.CustomerNotFoundException;
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
	private ICustomerRepository customerRepo;
	
	
	@Override
	public TripBooking addTripBooking(TripBooking tripbooking) {
		TripBooking newBooking = tripBookingRepo.save(tripbooking);
		System.out.println(newBooking+"****************");
		return newBooking;
	}
	
	@Override
	public TripBooking getTripBookingById(Long id) {
		TripBooking retVal=null;
		try {
			retVal = tripBookingRepo.findById(id).orElseThrow(TripBookingNotFoundException::new);
		} catch (TripBookingNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return retVal;
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
		TripBooking retrVal = null;
		try {
			retrVal=tripBookingRepo.findById(tripbookingId).orElseThrow(TripBookingNotFoundException::new);
				tripBookingRepo.deleteById(tripbookingId);
			
		} catch (TripBookingNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return retrVal;
	}

	@Override
	public List<TripBooking> getTripsByCustomer(Customer customer) {
		List<TripBooking> retVal=null;
		try {
			Customer temp = customerRepo.findById(customer.getId()).orElseThrow(CustomerNotFoundException::new);
			System.out.println(temp.getId());
			System.out.println(tripBookingRepo.findByCustomer(temp));
			retVal = tripBookingRepo.findByCustomer(temp);
		} catch (CustomerNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return retVal;
	}

	@Override
	public Float calculateBill(TripBooking tripbooking) {
		TripBooking retrVal = null;
		Float bill=null;
		try {
			retrVal=tripBookingRepo.findById(tripbooking.getId()).orElseThrow(TripBookingNotFoundException::new);
				bill = retrVal.getDistanceInKm()*retrVal.getCab().getPerKmRate();
				retrVal.setBill(bill);
				tripBookingRepo.save(retrVal);
			
		} catch (TripBookingNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return bill;
	}

	@Override
	public List<TripBooking> getAllTrips() {
		List<TripBooking> retVal = null;
		retVal = tripBookingRepo.findAll();
		return retVal;
	}

	
	@Override
	public List<TripBooking> getTripDateWise(LocalDateTime date) {
		List<TripBooking> retVal = tripBookingRepo.getTripDateWise(date);
		return retVal;
	}

	@Override
	public Float getDistanceInKm(TripBooking tripbooking) {
		TripBooking retVal = null;
		try {
			retVal = tripBookingRepo.findById(tripbooking.getId()).orElseThrow(TripBookingNotFoundException::new);
		} catch (TripBookingNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return retVal.getDistanceInKm();
	}

	
	@Override
	public TripBooking addUnassignedTripBooking(Long id, TripBooking tripBooking) {
		TripBooking trip = null;
		try {
			tripBooking.setStatus(Status.NOT_ALLOCATED);
			Customer c = customerRepo.findById(id).orElseThrow(CustomerNotFoundException::new);
			tripBooking.setCustomer(c);
			trip = tripBookingRepo.save(tripBooking);
		} catch (CustomerNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return trip;
	}

	
	
}
