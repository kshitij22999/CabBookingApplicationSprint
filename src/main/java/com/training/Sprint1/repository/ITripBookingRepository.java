package com.training.Sprint1.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.training.Sprint1.entities.TripBooking;

public interface ITripBookingRepository extends JpaRepository<TripBooking, Long>{

}
