package com.training.Sprint1.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
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
	public Driver updateDriver(Long driverId) throws DriverDoesNotExistException {
		Driver updatedDriver = repo.getById(driverId);
		updatedDriver.setDriverName(updatedDriver.getDriverName());
		updatedDriver.setRating(updatedDriver.getRating());
		updatedDriver.setLisenceNo(updatedDriver.getLisenceNo());
		return updatedDriver;
	}

	@Override
	public List<Driver> getAllDrivers(Driver driver) {
		List<Driver> list = repo.findAll();
		return list;
	}

	@Override
	public Driver deleteDriver(Long driverId) throws DriverDoesNotExistException {
		Driver deletedDriver =repo.getById(driverId);
		repo.delete(deletedDriver);
		return deletedDriver;
	}

	@Override
	@Query(value = "select d from driver dri where dri.rating > 4.5")
	public List<Driver> viewBestDrivers() {
		return null;
	}

	@Override
	public Driver viewDriverById(Long driverId) throws DriverDoesNotExistException {
		Driver dr = repo.getById(driverId);
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