package com.training.Sprint1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.training.Sprint1.entities.Driver;
import com.training.Sprint1.service.IDriverService;

@Controller
@RequestMapping("/driver")
public class DriverController {

	@Autowired
	IDriverService service;
	
	@PostMapping("/add")
	public ResponseEntity<Driver> addDriver(@RequestBody Driver driver){
		Driver addedDriver = service.addDriver(driver);
		return new ResponseEntity<Driver>(addedDriver,HttpStatus.CREATED);
		
	}

}
