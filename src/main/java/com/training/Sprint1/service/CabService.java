package com.training.Sprint1.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.training.Sprint1.entities.Cab;
import com.training.Sprint1.entities.carType;
import com.training.Sprint1.repository.ICabRepository;
import com.training.Sprint1.service.ICabService;


@Service
public class CabService implements ICabService {
	@Autowired
	ICabRepository iCabRepository;

	@Override
	public Cab insertCab(Cab cab) {
		return iCabRepository.save(cab);
	}

	@Override 
	public Cab updateCab(Cab cab) {
		Cab obj = iCabRepository.findById(cab.getCabId()).get();
		if (obj != null) {
			obj.setCarType(cab.getCarType());
			obj.setPerKmRate(cab.getPerKmRate());
		}
		return obj;
		
	}

	@Override
	public Cab deleteCab(String cabId) {
	//	return iCabRepository.deleteById(cabId);
		return null;
	}

	@Override
	public List<Cab> viewCabsOfType(String cabId) {
	//	return iCabRepository.findById(cabId);
		return null;
	}

	@Override
	public int countCabsOfType(carType carType) {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public List<Cab> getAllCabs() {
		return iCabRepository.findAll();
	}


	

}
