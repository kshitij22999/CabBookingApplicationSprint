package com.training.Sprint1.service;

import java.time.LocalDateTime;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.training.Sprint1.entities.Admin;
import com.training.Sprint1.entities.Cab;
import com.training.Sprint1.entities.CarType;
import com.training.Sprint1.entities.Customer;
import com.training.Sprint1.entities.Driver;
import com.training.Sprint1.entities.TripBooking;

@Service
@Transactional
public interface AdminService {

	public List<Admin> getAllAdmin();
	public Admin createAdmin(Admin admin);
	public Optional<Admin>getAdminById(Long id);
	public Admin updateAdmin(Admin admin);
	public void deleteAdmin(Admin admin);
	public Driver getDriverById(Long id);
	List<Cab>getAllCabs();
	List<Cab>viewCabsOfType(String cabId);
	List<Driver>getAllDrivers();
	public Driver addDriver(Driver driver);
	public void deleteDriver(Long driverId);
	List<TripBooking>getAllTrips();
	List<TripBooking>getTripsByCustomer(Customer customer);
	List<TripBooking>getTripDateWise(LocalDateTime date);
	Float getDistanceInKm(TripBooking tripbooking);
	
}

