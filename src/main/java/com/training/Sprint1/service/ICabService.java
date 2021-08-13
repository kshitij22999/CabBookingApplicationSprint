package com.training.Sprint1.service;
import java.util.List;

import org.springframework.stereotype.Service;

import com.training.Sprint1.entities.Cab;
import com.training.Sprint1.entities.carType;

@Service

public interface ICabService {
	public Cab insertCab(Cab cab);
	public Cab updateCab(String cabId);
	public Cab deleteCab(String cabId);
	public List<Cab> viewCabsOfType(carType carType);
	public int countCabsOfType(carType carType);

}
