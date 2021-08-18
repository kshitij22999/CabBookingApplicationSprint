
package com.training.Sprint1.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.training.Sprint1.entities.AvailabilityStatus;
import com.training.Sprint1.entities.Cab;
import com.training.Sprint1.entities.Driver;
import com.training.Sprint1.entities.Status;
import com.training.Sprint1.entities.TripBooking;
import com.training.Sprint1.exception.CabNotFoundException;
import com.training.Sprint1.exception.DriverDoesNotExistException;
import com.training.Sprint1.exception.TripBookingNotFoundException;
import com.training.Sprint1.repository.ICabRepository;
import com.training.Sprint1.repository.IDriverRepository;
import com.training.Sprint1.repository.ITripBookingRepository;

@Service
@Transactional
public class DriverService implements IDriverService{

	
	@Autowired
	private IDriverRepository driverRepo;
	
	@Autowired
	private ITripBookingRepository tripbookingRepo;
	
	@Autowired
	private ITripBookingService tripbookingService;
	
	@Autowired
	private ICabRepository cabRepo;
	
	@Autowired
	private ICabService cabService;
	
	
	
	@Override
	public Driver addDriver(Driver driver) {
		Driver addedDriver = driverRepo.save(driver);
		return addedDriver;
	}
	
	@Override
	public Driver updateDriver(Driver driver){
		Driver updatedDriver = null;
		try {
			updatedDriver = driverRepo.findById(driver.getId()).orElseThrow(DriverDoesNotExistException::new);
		} catch (DriverDoesNotExistException e) {
			
			e.printStackTrace();
		}
		updatedDriver.setDriverName(driver.getDriverName());
		updatedDriver.setRating(driver.getRating());
		updatedDriver.setLisenceNo(driver.getLisenceNo());
		updatedDriver.setVaccinationStatus(driver.getVaccinationStatus());
		updatedDriver.setEmail(driver.getEmail());
		updatedDriver.setMobileNumber(driver.getMobileNumber());
		updatedDriver.setAddress(driver.getAddress());
		updatedDriver.setAvailabilityStatus(driver.getAvailabilityStatus());
		updatedDriver.setPassword(driver.getPassword());
		updatedDriver.setUsername(driver.getUsername());
		updatedDriver.setId(driver.getId());
		
		Driver dvr = driverRepo.save(updatedDriver);
		return dvr;
	}

	@Override
	public List<Driver> getAllDrivers() {
		List<Driver> list = driverRepo.findAll();
		return list;
	}

	@Override
	public Driver deleteDriver(Long id)  {
		Driver deletedDriver = null;
		try {
			deletedDriver = driverRepo.findById(id).orElseThrow(DriverDoesNotExistException::new);
		} catch (DriverDoesNotExistException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driverRepo.delete(deletedDriver);
		return deletedDriver;
	}

	@Override
	public List<Driver> getBestDrivers() {
		List<Driver> retVal=null;
		retVal = driverRepo.getBestDrivers();
		return retVal;
	}

	@Override
	public Driver getDriverById(Long id){
		Driver dr=null;
		try {
			dr =driverRepo.findById(id).orElseThrow(DriverDoesNotExistException::new);
		} catch (DriverDoesNotExistException e) {
			e.printStackTrace();
		}
		return dr;
	}

	@Override
	public void startTrip(Driver driver) {
		driver.setAvailabilityStatus(AvailabilityStatus.Busy);		
		
	}

	@Override
	public void endTrip(Driver driver) {
	driver.setAvailabilityStatus(AvailabilityStatus.Available);	
	}

	@Override
	public TripBooking acceptBooking(Long id,Driver driver) {
		TripBooking trip = null;
		try {
			trip = tripbookingRepo.findById(id).orElseThrow(TripBookingNotFoundException::new);
			if(driver.getAvailabilityStatus()==AvailabilityStatus.Available) {
			driver.setAvailabilityStatus(AvailabilityStatus.Busy);
			trip.setDriver(driver);
			trip.setCab(driver.getCab());
			trip.setStatus(Status.ALLOCATED);
			Float bill = tripbookingService.calculateBill(trip);
			trip.setBill(bill);
			}
		} catch (TripBookingNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return trip;
	}

	@Override
	public Cab deleteCab(Long cabId)  {
		Cab deletedCab = null;
		try {
		deletedCab = cabRepo.findById(cabId).orElseThrow(CabNotFoundException::new);
		 cabRepo.delete(deletedCab); 
		
		} catch (CabNotFoundException e) {
			
			e.printStackTrace();
		}
		
		return deletedCab;
	}

	
	

	
}

