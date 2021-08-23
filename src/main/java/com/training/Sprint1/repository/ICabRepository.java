package com.training.Sprint1.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.training.Sprint1.entities.Cab;
import com.training.Sprint1.entities.CarType;



public interface ICabRepository  extends JpaRepository<Cab ,Long>  {
	@Query("select c FROM Cab c WHERE c.carType=:cartype")
	public List<Cab> viewCabsOfType(@Param("cartype") CarType carType);

	
}

