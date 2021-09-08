
package com.training.Sprint1.service;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.training.Sprint1.entities.AvailabilityStatus;

import com.training.Sprint1.entities.Driver;
import com.training.Sprint1.entities.LoginStatus;
import com.training.Sprint1.entities.Role;
import com.training.Sprint1.entities.Status;
import com.training.Sprint1.entities.TripBooking;
import com.training.Sprint1.entities.User;
import com.training.Sprint1.exception.CustomerNotFoundException;

import com.training.Sprint1.exception.DriverDoesNotExistException;
import com.training.Sprint1.exception.InvalidCredentials;
import com.training.Sprint1.exception.RoleNotFoundException;
import com.training.Sprint1.exception.TripBookingNotFoundException;
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
	private BCryptPasswordEncoder bcryptEncoder;
	
	@Autowired
	RoleService roleService;
	
	@Override
	public Driver addDriver(Driver driver) {
		driver.setAvailabilityStatus(AvailabilityStatus.Available);
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
		Driver driver=null;
		try {
			driver = driverRepo.findById(id).orElseThrow(DriverDoesNotExistException::new);
		} catch (DriverDoesNotExistException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driverRepo.delete(driver);
		return driver;
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
	public TripBooking acceptBooking(Long id,Driver temp) {
		TripBooking trip = null;
		Driver driver = null;
		try {
			trip = tripbookingRepo.findById(id).orElseThrow(TripBookingNotFoundException::new);
			driver = driverRepo.findById(temp.getId()).orElseThrow(DriverDoesNotExistException::new);
			if(driver.getAvailabilityStatus()==AvailabilityStatus.Available) {
			driver.setAvailabilityStatus(AvailabilityStatus.Busy);
			trip.setDriver(driver);
			trip.setCab(driver.getCab());
			trip.setStatus(Status.ALLOCATED);
			trip.setFromDateTime(LocalDateTime.now());
			trip.setToDateTime(LocalDateTime.now().plusHours(2));
			Float bill = tripbookingService.calculateBill(trip);
			trip.setBill(bill);
			}
		} catch (TripBookingNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (DriverDoesNotExistException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return trip;
	}

	@Override

	public Driver registerDriver(Driver driver) {
		driver.setAccountStatus(LoginStatus.LOGGEDOUT);
		Driver insertedDriver=driverRepo.save(driver);
		return insertedDriver;
	}

	@Override
	public Driver loginDriver(Driver driver) {
		Driver retCust=null;
		try {
			retCust = driverRepo.findById(driver.getId()).orElseThrow(CustomerNotFoundException::new);
			if(retCust.getUsername().equals(driver.getUsername()) && retCust.getPassword().equals(driver.getPassword())) {
				retCust.setAccountStatus(LoginStatus.LOGGEDIN);
				retCust = driverRepo.save(retCust);
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
			retCust = driverRepo.findById(driver.getId()).orElseThrow(CustomerNotFoundException::new);
			retCust.setAccountStatus(LoginStatus.LOGGEDOUT);
			retCust = driverRepo.save(retCust);
		} catch (CustomerNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return retCust;
	}

	@Override
	public List<Driver> getBadDrivers() {
		List<Driver> badDrivers = driverRepo.getBadDrivers();
		return badDrivers;
	}

	@Override
	public Driver getDriverByUsername(String username) {
		Driver driver = driverRepo.findByUsername(username);
		return driver;
	}
	
	@Override
    public Driver save(Driver user) throws RoleNotFoundException {
	    Driver driver = new Driver();
	    driver.setUsername(user.getUsername());
	    driver.setPassword(bcryptEncoder.encode(user.getPassword()));
	    Set<Role> roles= user.getRoles();
	    Set<Role> newSetOfRoles =  new HashSet<Role>();
	    
	    for(Role r:roles) {
	    	
	    	newSetOfRoles.add(roleService.findRoleById(r.getId()));
	    }
	    driver.setRoles(newSetOfRoles);
	    user.setAvailabilityStatus(AvailabilityStatus.Available);
	    System.out.println(newSetOfRoles+"************************");
		  Driver savedUser = driverRepo.save(user);
		  System.out.println(savedUser+"**************************");
		  return savedUser;
	}


}

