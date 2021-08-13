package com.training.Sprint1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.training.Sprint1.entities.TripBooking;

@Repository
public interface ITripBookingRepository extends JpaRepository<TripBooking, Long>{

}
