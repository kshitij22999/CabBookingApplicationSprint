package com.training.Sprint1.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.training.Sprint1.entities.Driver;

public interface IDriverRepository extends JpaRepository<Driver ,Long> {

	@Query(value = "from Driver dri where dri.getRating() >= 4.5")
	public List<Driver> getBestDrivers();
	

}