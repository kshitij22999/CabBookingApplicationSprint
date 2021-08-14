package com.training.Sprint1.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.training.Sprint1.entities.Driver;
import com.training.Sprint1.exception.DriverDoesNotExistException;

@Service
public interface IDriverService {
	
	public Driver addDriver(Driver driver);
	public Driver updateDriver(Driver driver) throws DriverDoesNotExistException;
	public List<Driver> getAllDrivers();
	public void deleteDriver(Long id) throws DriverDoesNotExistException;
	public List<Driver> getBestDrivers();
	public Driver getDriverById(Long id) throws DriverDoesNotExistException;
	public void startTrip(Driver driver);
	public void endTrip(Driver driver);

	

}
