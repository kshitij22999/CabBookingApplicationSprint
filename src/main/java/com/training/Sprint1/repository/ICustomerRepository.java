package com.training.Sprint1.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.training.Sprint1.entities.Customer;
import com.training.Sprint1.entities.TripBooking;

<<<<<<< HEAD
@SuppressWarnings("unused")
@Repository
public interface ICustomerRepository extends  JpaRepository<Customer,Long> {

}
=======
@Repository
public interface ICustomerRepository extends  JpaRepository<Customer,Long> {

}
>>>>>>> 3f78c0ae3dea4d2a27cc58bc35e07772819557f4
