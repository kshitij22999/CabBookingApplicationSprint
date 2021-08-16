package com.training.Sprint1.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.training.Sprint1.entities.Cab;
import com.training.Sprint1.entities.CarType;



@Service

public interface ICabService {
	public Cab insertCab(Cab cab);
	public Cab updateCab(Cab cab);
	public Cab deleteCab(String cabId);

	public List<Cab> viewCabsOfType(CarType carType);
	public int countCabsOfType(CarType carType);
	public List<Cab> getAllCabs();
}
