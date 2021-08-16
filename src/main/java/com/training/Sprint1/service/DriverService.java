
package com.training.Sprint1.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.training.Sprint1.entities.AvailabilityStatus;
import com.training.Sprint1.entities.Driver;
import com.training.Sprint1.exception.DriverDoesNotExistException;
import com.training.Sprint1.repository.IDriverRepository;

@Service
@Transactional
public class DriverService implements IDriverService{

	
	@Autowired
	private IDriverRepository repo;
	
	
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
		
		Driver dvr = repo.save(updatedDriver);
		return dvr;
	}

	@Override
	public List<Driver> getAllDrivers() {
		List<Driver> list = repo.findAll();
		return list;
	}

	@Override
	public void deleteDriver(Long id)  {
		try {
		Driver deletedDriver = repo.findById(id).orElseThrow(DriverDoesNotExistException::new);
		repo.delete(deletedDriver);
		} catch (DriverDoesNotExistException e) {
			
			e.printStackTrace();
		}
		
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
	
	

	
}

