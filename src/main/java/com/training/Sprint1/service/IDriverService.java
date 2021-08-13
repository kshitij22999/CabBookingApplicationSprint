package com.training.Sprint1.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.training.Sprint1.entities.Driver;
import com.training.Sprint1.exception.DriverDoesNotExistException;

@Service
public interface IDriverService {
	
	public Driver addDriver(Driver driver);
	public Driver updateDriver(Driver driver) throws DriverDoesNotExistException;
	public List<Driver> getAllDrivers(Driver driver);
	public Driver deleteDriver(Long driverId) throws DriverDoesNotExistException;
	public List<Driver> viewBestDrivers();
	public Driver viewDriver(Long driverId) throws DriverDoesNotExistException;

}
