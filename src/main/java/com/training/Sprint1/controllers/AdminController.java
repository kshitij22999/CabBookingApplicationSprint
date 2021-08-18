package com.training.Sprint1.controllers;

import java.time.LocalDateTime;
import java.util.HashMap;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.training.Sprint1.entities.Admin;
import com.training.Sprint1.entities.Cab;
import com.training.Sprint1.entities.Driver;
import com.training.Sprint1.entities.TripBooking;
import com.training.Sprint1.entities.CarType;
import com.training.Sprint1.entities.Customer;
import com.training.Sprint1.exception.AdminNotFoundException;
import com.training.Sprint1.exception.CabNotFoundException;
import com.training.Sprint1.exception.DriverDoesNotExistException;
import com.training.Sprint1.exception.TripBookingNotFoundException;
import com.training.Sprint1.service.AdminService;
import com.training.Sprint1.service.CabService;
import com.training.Sprint1.service.DriverService;
import com.training.Sprint1.service.TripBookingService;


@RestController
@RequestMapping("/api")
public class AdminController {
	@Autowired
	private AdminService adminService;
	
	@Autowired
	private DriverService driverService;
	
	@Autowired
	private CabService cabService;
	
	@Autowired
	private TripBookingService tripBookingService;
	
	@PostMapping("/admin/newadmin")
	public Admin createAdmin(@RequestBody Admin admin) { 
		return adminService.createAdmin(admin);
	}
	
	@GetMapping("/admin/id/{id}")
	public ResponseEntity<Admin> getAdminById(@PathVariable(value="id") Long id) throws AdminNotFoundException 
	{
		Admin admin = adminService.getAdminById(id);
		return ResponseEntity.ok().body(admin);
	}
	
	@GetMapping("/admin/all")
	public List<Admin> getAllAdmin()
	{
		return adminService.getAllAdmin();
	}
	
	
	@PutMapping("/admin/update/{id}")
	public ResponseEntity<Admin> updateAdmin(@PathVariable(value="id") Long id,@RequestBody Admin admin) throws AdminNotFoundException
	{
		Admin updatedAdmin = adminService.updateAdmin(id,admin);
	    return new ResponseEntity<Admin>(updatedAdmin, HttpStatus.OK);
    }
	
	@DeleteMapping("/admins/{id}")
	public ResponseEntity<Admin> deleteAdmin(@RequestBody Admin admin) throws AdminNotFoundException{
		return new ResponseEntity<Admin>(adminService.deleteAdmin(admin), HttpStatus.OK);
	}
	
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public Map<String,String> handleMethodArgumentNotValid(MethodArgumentNotValidException ex)
	{
		Map<String,String> errors=new HashMap<>();
		ex.getBindingResult().getFieldErrors().forEach(error->errors.put(error.getField(),error.getDefaultMessage()));
		return errors;
	}
	
	@GetMapping("/driver/all")
	public List<Driver> getAllDrivers()
	{
		return driverService.getAllDrivers();
	}
	
	@GetMapping("/cab/all")
	public List<Cab> getAllCabs()
	{
		return cabService.getAllCabs();
	}
	
	
	@GetMapping("/cab/CarType/{CarType}")
	public List<Cab>viewCabOfTypes(@PathVariable("CarType") CarType carType)
	{
		return cabService.viewCabsOfType(carType) ;
	}
	
	@GetMapping("/tripBooking/all")
	public List<TripBooking> getAllTrips()
	{
		return tripBookingService.getAllTrips();
	}
	
	@GetMapping("/tripBooking/customer/{customer}")
	public ResponseEntity<List<TripBooking>> getTripsByCustomer(@RequestBody Customer customer) throws TripBookingNotFoundException
	{
		return new ResponseEntity<List<TripBooking>>(tripBookingService.getTripsByCustomer(customer), HttpStatus.OK);
		 
	}
	
	@GetMapping("/tripBookings/LocalDateTime/{date}")
	public ResponseEntity<List<TripBooking>> getTripDateWise(@RequestParam LocalDateTime date) throws TripBookingNotFoundException
	{
		List<TripBooking>trb=tripBookingService.getTripDateWise(date);
		return new ResponseEntity<List<TripBooking>>(trb,HttpStatus.OK);
		
	}
	
	@PostMapping("/drivers/add")
	public Driver addDriver(@RequestBody Driver driver){
		return driverService.addDriver(driver);
	}
	@GetMapping("/tripbookings/{id}")
	public ResponseEntity<TripBooking> getTripBookingById(@RequestParam Long id)throws TripBookingNotFoundException{
	return new ResponseEntity<TripBooking>(tripBookingService.getTripBookingById(id),HttpStatus.OK);
	}
	@GetMapping("/drivers/{id}")
	public ResponseEntity<Driver> getDriversById(@RequestParam Long id) throws DriverDoesNotExistException {
		Driver dr=driverService.getDriverById(id);
		if(dr==null)
		{
			return new ResponseEntity("Sorry! Driver Not Found", HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Driver>(dr, HttpStatus.NOT_FOUND);
		
	}
	@DeleteMapping("/drivers/delete/{id}")
	
	public ResponseEntity<Driver> deleteDriver(@RequestParam Long id) throws DriverDoesNotExistException{
		return new ResponseEntity<Driver>(driverService.deleteDriver(id), HttpStatus.OK);
	}
	

	@PostMapping("/admin/register")
	public ResponseEntity<Admin> registerAdmin(@RequestBody Admin admin){
		Admin temp = adminService.registerAdmin(admin);
		return new ResponseEntity<Admin>(temp,HttpStatus.OK);
	}
	
	@PutMapping("/admin/login")
	public ResponseEntity<Admin> loginAdmin(@RequestBody Admin admin){
		Admin temp = adminService.loginAdmin(admin);
		return new ResponseEntity<Admin>(temp,HttpStatus.OK);
	}
	
	@PutMapping("/admin/logout")
	public ResponseEntity<Admin> logoutCustomer(@RequestBody Admin admin){
		Admin temp = adminService.logoutAdmin(admin);
		return new ResponseEntity<Admin>(temp,HttpStatus.OK);
	}
}

