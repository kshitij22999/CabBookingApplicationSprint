
package com.training.Sprint1.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.training.Sprint1.entities.AvailabilityStatus;
import com.training.Sprint1.entities.Customer;
import com.training.Sprint1.entities.Driver;
import com.training.Sprint1.entities.LoginStatus;
import com.training.Sprint1.entities.Status;
import com.training.Sprint1.entities.TripBooking;
import com.training.Sprint1.exception.CustomerNotFoundException;
import com.training.Sprint1.exception.DriverDoesNotExistException;
import com.training.Sprint1.exception.InvalidCredentials;
import com.training.Sprint1.exception.TripBookingNotFoundException;
import com.training.Sprint1.repository.IDriverRepository;
import com.training.Sprint1.repository.ITripBookingRepository;

@Service
@Transactional
public class DriverService implements IDriverService{

	
	@Autowired
	private IDriverRepository repo;
	
	@Autowired
	private ITripBookingRepository tripbookingRepo;
	
	@Autowired
	private ITripBookingService tripbookingService;
	
	
	@Override
	public Driver addDriver(Driver driver) {
		Driver addedDriver = repo.save(driver);
		return addedDriver;
	}
	
	@Override
	public Driver updateDriver(Driver driver){
		Driver updatedDriver = null;
		try {
			updatedDriver = repo.findById(driver.getId()).orElseThrow(DriverDoesNotExistException::new);
		} catch (DriverDoesNotExistException e) {
			
			e.printStackTrace();
		}
		updatedDriver.setDriverName(updatedDriver.getDriverName());
		updatedDriver.setRating(updatedDriver.getRating());
		updatedDriver.setLisenceNo(updatedDriver.getLisenceNo());
		updatedDriver.setVaccinationStatus(updatedDriver.getVaccinationStatus());
		
		Driver dvr = repo.save(updatedDriver);
		return dvr;
	}

	@Override
	public List<Driver> getAllDrivers() {
		List<Driver> list = repo.findAll();
		return list;
	}

	@Override
	public Driver deleteDriver(Driver driver)  {
		Driver deletedDriver = null;
		try {
		deletedDriver = repo.findById(driver.getId()).orElseThrow(DriverDoesNotExistException::new);
		repo.delete(deletedDriver); 
		
		} catch (DriverDoesNotExistException e) {

			e.printStackTrace();
		}
		
		return deletedDriver;
	}
	

	@Override
	public List<Driver> getBestDrivers() {
		List<Driver> retVal=null;
		retVal = repo.getBestDrivers();
		return retVal;
	}

	@Override
	public Driver getDriverById(Long id){
		Driver dr=null;
		try {
			dr = repo.findById(id).orElseThrow(DriverDoesNotExistException::new);
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
	public Driver registerDriver(Driver driver) {
		driver.setAccountStatus(LoginStatus.LOGGEDOUT);
		Driver insertedDriver=repo.save(driver);
		return insertedDriver;
	}

	@Override
	public Driver loginDriver(Driver driver) {
		Driver retCust=null;
		try {
			retCust = repo.findById(driver.getId()).orElseThrow(CustomerNotFoundException::new);
			if(retCust.getUsername().equals(driver.getUsername()) && retCust.getPassword().equals(driver.getPassword())) {
				retCust.setAccountStatus(LoginStatus.LOGGEDIN);
				retCust = repo.save(retCust);
			}else {
				throw new InvalidCredentials("Wrong credentials");
			}
		} catch (CustomerNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch(InvalidCredentials i) {
			i.printStackTrace();
		}
		return retCust;
	}

	@Override
	public Driver logoutDriver(Driver driver) {
		Driver retCust=null;
		try {
			retCust = repo.findById(driver.getId()).orElseThrow(CustomerNotFoundException::new);
			retCust.setAccountStatus(LoginStatus.LOGGEDOUT);
			retCust = repo.save(retCust);
		} catch (CustomerNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return retCust;
	}


	
	

	
}

