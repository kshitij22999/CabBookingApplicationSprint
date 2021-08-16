package com.training.Sprint1.service;
<<<<<<< HEAD

=======
>>>>>>> 3f78c0ae3dea4d2a27cc58bc35e07772819557f4
import java.util.List;

import org.springframework.stereotype.Service;

import com.training.Sprint1.entities.Cab;
<<<<<<< HEAD
import com.training.Sprint1.entities.CarType;
=======
import com.training.Sprint1.entities.carType;
>>>>>>> 3f78c0ae3dea4d2a27cc58bc35e07772819557f4

@Service

public interface ICabService {
	public Cab insertCab(Cab cab);
	public Cab updateCab(String cabId);
	public Cab deleteCab(String cabId);
<<<<<<< HEAD
	public List<Cab> viewCabsOfType(CarType carType);
	public int countCabsOfType(CarType carType);
=======
	public List<Cab> viewCabsOfType(carType carType);
	public int countCabsOfType(carType carType);
>>>>>>> 3f78c0ae3dea4d2a27cc58bc35e07772819557f4

}
