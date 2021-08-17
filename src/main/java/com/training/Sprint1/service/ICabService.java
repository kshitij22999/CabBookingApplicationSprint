package com.training.Sprint1.service;
import java.util.List;

import org.springframework.stereotype.Service;

import com.training.Sprint1.entities.Cab;
import com.training.Sprint1.entities.CarType;
import com.training.Sprint1.exception.CabNotFoundException;


@Service

public interface ICabService {
	public Cab insertCab(Cab cab);
	//public List<Cab> addAll(List<Cab> cabList);
	public Cab updateCab(Cab cab) throws CabNotFoundException ;
	public Cab deleteCab(Long cabId) throws CabNotFoundException;
	public List<Cab> viewCabsOfType(CarType carType);
	public List<Cab> getAllCabs();
	public int countCabs(CarType carType);
	public Cab addCab(Cab cab);
	public Cab getByCabId(Long cabId) throws CabNotFoundException;
	

}