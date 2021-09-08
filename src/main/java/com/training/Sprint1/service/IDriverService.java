
package com.training.Sprint1.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.training.Sprint1.entities.Driver;
import com.training.Sprint1.entities.TripBooking;
import com.training.Sprint1.entities.User;
import com.training.Sprint1.exception.DriverDoesNotExistException;
import com.training.Sprint1.exception.RoleNotFoundException;

@Service
@Transactional
public interface IDriverService {
	
	public Driver addDriver(Driver driver);
	public Driver updateDriver(Driver driver) throws DriverDoesNotExistException;
	public Driver deleteDriver(Long id)  throws DriverDoesNotExistException;
	public List<Driver> getAllDrivers();
	public List<Driver> getBestDrivers();
	public List<Driver> getBadDrivers();
	public Driver getDriverById(Long id) throws DriverDoesNotExistException;
	public TripBooking acceptBooking(Long id,Driver driver);
	public Driver registerDriver(Driver driver);
	public Driver loginDriver(Driver driver);
	public Driver logoutDriver(Driver driver);
	public Driver getDriverByUsername(String username);
	Driver save(Driver user) throws RoleNotFoundException;
	

	

}