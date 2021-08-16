package com.training.Sprint1.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import com.training.Sprint1.entities.Cab;
import com.training.Sprint1.entities.Driver;

public interface ICabRepository  extends JpaRepository<Cab ,Long>  {

	Optional<Cab> getCabById(String cabId);

	Optional<Cab> findByCabId(String cabId);

	
}
