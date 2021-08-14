package com.training.Sprint1;

import static org.mockito.Mockito.when;

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
	void setUp() {
		MockitoAnnotations.initMocks(this);
		
		d1 = new Driver("Charan", "DL2021ABC", new Cab(carType.Santro, 21));
		
		d2 = new Driver("Hari", "DL2012MAH", new Cab(carType.Alto, 12));
		
		d3 = new Driver("Bhanu", "DL2018XYZ", new Cab(carType.SwiftDzire, 25));
		
		
		}
	@Test
	void testaddDriver() {
		when(repo.save(d1)).thenReturn(d1);
		Assertions.assertThat(service.addDriver(d1));
	}

}
