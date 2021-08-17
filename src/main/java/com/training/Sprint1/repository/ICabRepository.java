package com.training.Sprint1.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.training.Sprint1.entities.Cab;
import com.training.Sprint1.entities.CarType;

public interface ICabRepository  extends JpaRepository<Cab ,Long>  {
	
	public List<Cab> findByCarType(CarType carType);
	

	
	

}
