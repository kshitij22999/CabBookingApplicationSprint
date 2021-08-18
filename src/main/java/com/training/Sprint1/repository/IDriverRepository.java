package com.training.Sprint1.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.training.Sprint1.entities.Driver;

@Repository
public interface IDriverRepository extends JpaRepository<Driver ,Long> {

	@Query("from Driver d where d.rating >= 4.5")
	public List<Driver> getBestDrivers();
	

}