package com.training.Sprint1;

import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import com.training.Sprint1.entities.Cab;
import com.training.Sprint1.entities.Driver;
import com.training.Sprint1.entities.VaccinationStatus;
import com.training.Sprint1.entities.carType;
import com.training.Sprint1.repository.IDriverRepository;
import com.training.Sprint1.service.DriverService;

@SpringBootTest
class DriverTest {

	@Mock
	IDriverRepository repo;
	
	@InjectMocks
	DriverService service;
	
	Driver d1,d2,d3;
	List<Driver> driverList;

	@SuppressWarnings("deprecation")
	@BeforeEach
	void setUpBeforeClass() throws Exception {
		MockitoAnnotations.initMocks(this);
		
		driverList = new ArrayList<>();
		
		d1 = new Driver("Hari", "DL2012MAH",4.9F ,new Cab(carType.Alto, 12),VaccinationStatus.Not_Vaccinated);
		
		d2 = new Driver("Bhanu", "DL2018XYZ",3.7F, new Cab(carType.SwiftDzire, 25), VaccinationStatus.SecondDose_Done);
		
		d3 = new Driver("HansRaj","DL2015GIF", 4.1F, new Cab(carType.Etios, 18), VaccinationStatus.FirstDose_Done);
		
		driverList.add(d1);
		driverList.add(d2);
		driverList.add(d3);
	}
	@Test
	public void testAddDriver() {
		when(repo.save(d1)).thenReturn(d1);
		Assertions.assertThat(service.addDriver(d1));
	}
	
	@Test
	public void testGetAllDrivers() {
		when(repo.findAll()).thenReturn(driverList);
		Assertions.assertThat(service.getAllDrivers().size());
	}
	
	@Test
	public void getDriverById() {
		when(repo.findById(d1.getId());
		Assertions.assertThat(service.getDriverById(id));
	}
	
	}
}
