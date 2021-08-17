package com.training.Sprint1.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.training.Sprint1.entities.Cab;
import com.training.Sprint1.entities.CarType;



public interface ICabRepository  extends JpaRepository<Cab ,Long>  {
	@Query("FROM Cab c WHERE c.carType=?1")
	public List<Cab> viewCabsOfType(CarType carType);
	
	@Query("SELECT COUNT(*) FROM Cab c WHERE c.carType=?1")
	public int countCabsOfType(CarType carType);
	

	
	

}
