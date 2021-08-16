package com.training.Sprint1.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.training.Sprint1.entities.Cab;




public interface ICabRepository  extends JpaRepository<Cab ,Long>  {

	
	

}
