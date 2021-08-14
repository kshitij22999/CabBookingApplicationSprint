package com.training.Sprint1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.training.Sprint1.entities.Cab;
import com.training.Sprint1.service.ICabService;

@RestController 
@RequestMapping(path="/cab")

public class CabController {
	@Autowired
	ICabService iCabService;
	
	@PostMapping("/add")
	public ResponseEntity<Cab> addCab(@RequestBody Cab cab){
		//Cab addedcab = service.addCab(cab);
		//return new ResponseEntity<Cab>(addedcab,HttpStatus.CREATED);
		return null;
	}


}
