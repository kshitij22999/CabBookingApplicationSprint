package com.training.Sprint1.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.training.Sprint1.entities.Driver;

public interface IDriverRepository extends JpaRepository<Driver ,Long> {

}
