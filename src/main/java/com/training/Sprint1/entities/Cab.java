package com.training.Sprint1.entities;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="cba_cab1")
public class Cab {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long cabId;
	
	@Enumerated(EnumType.STRING)
	private CarType carType;
	
	private Double perKmRate;
	
	public Cab() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Cab(Long cabId, CarType carType, Double perKmRate) {
		super();
		this.cabId = cabId;
		this.carType = carType;
		this.perKmRate = perKmRate;
	}

	public Cab(CarType carType, Double perKmRate) {
		super();
		this.carType = carType;
		this.perKmRate = perKmRate;
	}

	public Long getCabId() {   
		return cabId;
	}

	public void setCabId(Long cabId) {
		this.cabId = cabId;
	}

	public CarType getCarType() {
		return carType;
	}

	public void setCarType(CarType carType) {
		this.carType = carType;
	}

	public Double getPerKmRate() {
		return perKmRate;
	}

	public void setPerKmRate(Double perKmRate) {
		this.perKmRate = perKmRate;
	}

	@Override
	public String toString() {
		return "Cab [cabId=" + cabId + ", carType=" + carType + ", perKmRate=" + perKmRate + "]";
	}
	
	
	
}
