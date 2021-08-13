package com.training.Sprint1.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.training.Sprint1.entities.TripBooking;

@Repository
public interface ITripBookingRepository extends JpaRepository<TripBooking, Long>{

	@Query(value="SELECT tb FROM TripBooking t WHERE t.getCustomer().getCustomerId()=:customerId")
	public List<TripBooking> getTripsByCustomerId(@Param("customerId") Long customerId);
	
	@Query(value="SELECT tb FROM TripBooking t WHERE t.getToDateTime()=:date")
	public List<TripBooking> getTripDateWise(@Param("date") LocalDateTime date);
		
}
