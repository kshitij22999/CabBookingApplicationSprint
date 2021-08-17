package com.training.Sprint1;

import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.training.Sprint1.entities.Cab;
import com.training.Sprint1.entities.CarType;
import com.training.Sprint1.repository.ICabRepository;
import com.training.Sprint1.service.CabService;

@SuppressWarnings("unused")

public class CabTest {
	
	@Mock
	ICabRepository repo;
	
	@InjectMocks
	CabService service;
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}
	
	Cab c1,c2,c3;
	List<Cab> cabList;
	List<Cab> bestCab;

	@SuppressWarnings("deprecation")
	@BeforeEach
	void setUp() throws Exception{
		MockitoAnnotations.initMocks(this);
		
		cabList = new ArrayList<>();
		
		c1=new Cab(CarType.Alto,9);
		c2=new Cab(CarType.Etios,10);
		c1=new Cab(CarType.Santro,10);
		
		cabList.add(c1);
		cabList.add(c2);
		cabList.add(c3);
		
		bestCab = new ArrayList<Cab>();
		bestCab.add(c1);
	}
	
	@AfterEach
	void tearDown() throws Exception {
	}
	
	
	@Test
	public void addCabTest() {
		when(repo.save(c1)).thenReturn(c1);
		Assertions.assertEquals(c1,service.addCab(c1));
	}
	
	@Test
	public void getAllCabTest() {
		when(repo.findAll()).thenReturn(cabList);
		Assertions.assertEquals(3,service.getAllCabs().size());
	}
	
	@Test
	public void updateCabTest() {
		when(repo.findById(c1.getCabId())).thenReturn(Optional.of(c1));
		when(repo.save(c1)).thenReturn(c1);
		Assertions.assertEquals(c1,service.updateCab(c1));

	}
	@Test
	public void getCabByIdTest() {
		when(repo.findById(c1.getCabId())).thenReturn(Optional.of(c1));
		Assertions.assertEquals(c1, service.getByCabId(c1.getCabId()));	
		}
	
	@Test
	public void deleteCabTest() {
		when(repo.findById(c1.getCabId())).thenReturn(Optional.of(c1));
		Assertions.assertEquals(c1 , service.deleteCab(c1.getCabId()));
	}
	

}
