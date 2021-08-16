package com.training.Sprint1;

import static org.mockito.Mockito.when;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import com.training.Sprint1.entities.Cab;
import com.training.Sprint1.entities.Customer;
import com.training.Sprint1.entities.Driver;
import com.training.Sprint1.entities.Status;
import com.training.Sprint1.entities.TripBooking;
import com.training.Sprint1.entities.VaccinationStatus;
import com.training.Sprint1.entities.carType;
import com.training.Sprint1.repository.ICustomerRepository;
import com.training.Sprint1.repository.ITripBookingRepository;
import com.training.Sprint1.service.ICustomerService;
import com.training.Sprint1.service.ICustomerServiceImpl;
import com.training.Sprint1.service.TripBookingService;

@SpringBootTest
public class TripBookingTest {
	
	@Mock
	ITripBookingRepository tripBookingRepo;
	
	@InjectMocks
	TripBookingService tripBookingService;
	
	@Mock
	ICustomerRepository customerRepo;
	
	//@InjectMocks
	//ICustomerServiceImpl customerService;
	
	TripBooking tb1,tb2,tb3;
	List<TripBooking> lstTripBooking;
	
	Customer customer1;
	
	Cab cab1,cab2,cab3;
	
	Driver d1,d2,d3;
	
	LocalDateTime date;
	
	@SuppressWarnings("deprecation")
	@BeforeEach
	void setBeforeClass() throws Exception{
		MockitoAnnotations.initMocks(this);
		
		date = LocalDateTime.now();
		
		customer1 = new Customer(11L,"Kshitij");
		
		cab1 = new Cab(5L,carType.Alto, 12);
		
		cab2 = new Cab(6L,carType.SwiftDzire, 25);
		
		cab3 =new Cab(7L,carType.Etios, 18);
		
		d1 = new Driver("Hari", "DL2012MAH",4.9F ,cab1,VaccinationStatus.Not_Vaccinated);
		
		d2 = new Driver("Bhanu", "DL2018XYZ",3.7F,cab2 , VaccinationStatus.SecondDose_Done);
		
		d3 = new Driver("HansRaj","DL2015GIF", 4.1F, cab3, VaccinationStatus.FirstDose_Done);
		
		lstTripBooking = new ArrayList<TripBooking>();
		
		tb1 = new TripBooking(101L,d1, customer1,cab1,"Andheri","Bandra", date, date,Status.ALLOCATED,11, 400);

		tb2 = new TripBooking(102L,d2, customer1,cab2,"Mumbai", "Pune", date, date,Status.NOT_ALLOCATED,80, 3000);
		
		tb3 = new TripBooking(104L,d3, customer1,cab3,"Delhi", "Mumbai", date, date,Status.ALLOCATED,3002, 40000);
		
		lstTripBooking.add(tb1);
		lstTripBooking.add(tb2);
		lstTripBooking.add(tb3);
	
	}
	
	@Test
	public void addTripBookingTest() {
		when(tripBookingRepo.save(tb1)).thenReturn(tb1);
		Assertions.assertEquals(tb1,tripBookingService.addTripBooking(tb1));
	}
	
	@Test
	public void updateTripBookingTest() {
		when(tripBookingRepo.findById(tb1.getId())).thenReturn(Optional.of(tb1));
		when(tripBookingRepo.save(tb1)).thenReturn(tb1);
		Assertions.assertEquals(tb1,tripBookingService.updateTripBooking(tb1));
	}
	
	@Test
	public void getTripDateWiseTest() {
		when(tripBookingRepo.getTripDateWise(date)).thenReturn(lstTripBooking);
		Assertions.assertEquals(lstTripBooking, tripBookingService.getTripDateWise(date));
	}
	
	@Test
	public void getAllTripsTest() {
		when(tripBookingService.getAllTrips()).thenReturn(lstTripBooking);
		Assertions.assertEquals(3, tripBookingService.getAllTrips().size());
	}
	
	@Test
	public void calculateBillTest() {
		when(tripBookingRepo.findById(tb1.getId())).thenReturn(Optional.of(tb1));
		Assertions.assertEquals(11*12, tripBookingService.calculateBill(tb1).getBill());
	}
	
	@Test
	public void getDistanceInKmTest() {
		when(tripBookingRepo.findById(tb1.getId())).thenReturn(Optional.of(tb1));
		Assertions.assertEquals(11, tripBookingService.getDistanceInKm(tb1));
	}
	
	@Test
	public void getTripsByCustomer() {
		when(customerRepo.findById(customer1.getId())).thenReturn(Optional.of(customer1));
		Assertions.assertEquals(lstTripBooking, tripBookingService.getTripsByCustomer(customer1));
	}
}
