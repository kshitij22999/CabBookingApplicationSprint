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
		LocalDateTime date = LocalDateTime.now();
		
		Customer customer1 = new Customer(11L,"Kshitij");
		
		Cab cab1 = new Cab(5L,CarType.Alto, 12D);
		
		Cab cab2 = new Cab(6L,CarType.SwiftDzire, 25D);
		
		Cab cab3 =new Cab(7L,CarType.Etios, 18D);
		
		Driver d1 = new Driver("Hari", "DL2012MAH",4.9F ,cab1,VaccinationStatus.Not_Vaccinated);
		
		Driver d2 = new Driver("Bhanu", "DL2018XYZ",3.7F,cab2 , VaccinationStatus.SecondDose_Done);
		
		Driver d3 = new Driver("HansRaj","DL2015GIF", 4.1F, cab3, VaccinationStatus.FirstDose_Done);
	
		
		TripBooking tb1 = new TripBooking(101L,d1, customer1,cab1,"Andheri","Bandra", date, date,Status.ALLOCATED,11, 400);

		TripBooking tb2 = new TripBooking(102L,d2, customer1,cab2,"Mumbai", "Pune", date, date,Status.NOT_ALLOCATED,80, 3000);
		
		TripBooking tb3 = new TripBooking(104L,d3, customer1,cab3,"Delhi", "Mumbai", date, date,Status.ALLOCATED,3002, 40000);
		
		TripBooking temp1 = tripBookingRepo.save(tb1);
		temp1 = tripBookingRepo.save(tb2);
		temp1 = tripBookingRepo.save(tb3);
		TripBooking newBooking = tripBookingRepo.save(tripbooking);
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
			if(retrVal==null) {
				throw new TripBookingNotFoundException();
			}else {
				tripBookingRepo.deleteAllById(null);
			}
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
	public TripBooking calculateBill(TripBooking tripbooking) {
		TripBooking retrVal = null;
		try {
			retrVal=tripBookingRepo.findById(tripbooking.getId()).orElseThrow(TripBookingNotFoundException::new);
				Float bill = retrVal.getDistanceInKm()*retrVal.getCab().getPerKmRate();
				retrVal.setBill(bill);
				tripBookingRepo.save(retrVal);
			
		} catch (TripBookingNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return retrVal;
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

}
