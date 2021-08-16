package com.training.Sprint1.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.training.Sprint1.entities.Cab;
import com.training.Sprint1.service.ICabService;

@RestController 
@RequestMapping(path="/cab")

public class CabController {
	@Autowired
	ICabService iCabService;
	
	@PostMapping(path="/add")
	public Cab insertCab(@RequestBody Cab cab){
		return iCabService.insertCab(cab);
	}
	

	@PostMapping(path="/update")
	public Cab updateCab(@RequestBody Cab cab){
		return iCabService.updateCab(cab);
	}
	
	@DeleteMapping(path="/delete")
	public Cab deleteCab(@RequestParam String cabId) {
		return iCabService.deleteCab(cabId);
	}
	
	@GetMapping(path="/getAllCabs")
	public List<Cab> getAllCabs(){
		return iCabService.getAllCabs();
	}
	
	@GetMapping(path="viewCabsOfType")
	public List<Cab> viewCabsOfType(@RequestParam String cabId){
		return iCabService.viewCabsOfType(cabId);
	}
	

}
