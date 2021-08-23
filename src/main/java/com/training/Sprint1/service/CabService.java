package com.training.Sprint1.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.training.Sprint1.entities.Cab;
import com.training.Sprint1.entities.CarType;
import com.training.Sprint1.exception.CabNotFoundException;
import com.training.Sprint1.repository.ICabRepository;
import com.training.Sprint1.service.ICabService;


@Service("cabService")
public class CabService implements ICabService {
	@Autowired
	ICabRepository cRepo;
	
	@Override
	public Cab insertCab(Cab cab) {
		cRepo.saveAndFlush(cab);
		return cab;
	}
		
	
	@Override
	public Cab updateCab(Cab cab){
		Cab updatedCab = null;
		try {
			updatedCab= cRepo.findById(cab.getCabId()).orElseThrow(CabNotFoundException::new);
		} catch (CabNotFoundException e) {
			
			e.printStackTrace();
		}
		updatedCab.setCarType(cab.getCarType());
		updatedCab.setPerKmRate(cab.getPerKmRate());
		
		Cab cust = cRepo.save(updatedCab);
		return cust;
	}
	
	
	@Override
	public Cab deleteCab(Long cabId)  {
		Cab deletedCab = null;
		try {
		deletedCab = cRepo.findById(cabId).orElseThrow(CabNotFoundException::new);
		 cRepo.delete(deletedCab); 
		
		} catch (CabNotFoundException e) {
			
			e.printStackTrace();
		}
		
		return deletedCab;
	}

	
	@Override
	public List<Cab> getAllCabs() {
		List<Cab> list = cRepo.findAll();
		return list;}
	


	@Override
	public List<Cab> viewCabsOfType(CarType carType) {
		List<Cab> list=null;
		list=cRepo.viewCabsOfType(carType);
		return list;
	}

	@Override
	public Cab addCab(Cab cab) {
		Cab retcab=cRepo.save(cab);
		return retcab;
	}

	@Override
	public Cab getByCabId(Long cabId) {
		Cab getCab=null;
		try {
			getCab = cRepo.findById(cabId).orElseThrow(CabNotFoundException::new);
		} catch (CabNotFoundException e) {
			e.printStackTrace();
		}
		return getCab;
	
}
	}
