package com.training.Sprint1.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.training.Sprint1.entities.Cab;
import com.training.Sprint1.entities.CarType;
import com.training.Sprint1.exception.CabNotFoundException;
import com.training.Sprint1.service.ICabService;

@RestController 
@RequestMapping(path="/cab")

public class CabController {
	@Autowired
	ICabService iCabService;
	
	
	
	@PostMapping(path="/add")
	public ResponseEntity<Cab>insertCab(@RequestBody Cab cab){
		Cab addedCab =  iCabService.addCab(cab);
		return new ResponseEntity<Cab>(addedCab, HttpStatus.OK);
	}
	
	

	@PutMapping(path="/update")
	public ResponseEntity<Cab> updateCab(@RequestBody Cab cab) throws CabNotFoundException{
		return new ResponseEntity<Cab>(iCabService.updateCab(cab), HttpStatus.OK);
	}
	
	@DeleteMapping(path="/delete/{id}")
	public ResponseEntity<Cab>  deleteCab(@PathVariable("id") Long id) throws CabNotFoundException {
		return new ResponseEntity<Cab>(iCabService.deleteCab(id), HttpStatus.OK);
	}
	
	
	
	@GetMapping(path="/getAllCabs")
	public ResponseEntity<List<Cab>> getAllCabs(){
		return new ResponseEntity<List<Cab>>(iCabService.getAllCabs(),HttpStatus.OK);
	}
	
	@GetMapping(path="viewCabsOfType")
	public ResponseEntity<List<Cab>>viewCabsOfType(@RequestParam CarType carType){
		return  new ResponseEntity<List<Cab>>(iCabService.viewCabsOfType(carType),HttpStatus.OK);
	}
	

}