package com.training.Sprint1.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.training.Sprint1.entities.Customer;
import com.training.Sprint1.entities.TripBooking;

@Repository
public interface ITripBookingRepository extends JpaRepository<TripBooking, Long>{
	
	@Query(value="from TripBooking where customer=:c")
	public List<TripBooking> findByCustomer(@Param("c") Customer customer);
	
	
	//@Query(value="from TripBooking where customer in (from Customer where id=:customerId)")
	//public List<TripBooking> getTripsByCustomerId(@Param("customerId") Long customerId);
	
	@Query(value="from TripBooking where fromDateTime>:date and toDateTime<=:date")
	public List<TripBooking> getTripDateWise(@Param("date") LocalDateTime date);
		
}
