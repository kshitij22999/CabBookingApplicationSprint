package com.training.Sprint1.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="cba_cab")
public class Cab {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int cabId;
	
	private carType carType;
	private float perKmRate;
	
	public Cab() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public Cab(int cabId, carType carType, float perKmRate) {
		super();
		this.cabId = cabId;
		this.carType = carType;
		this.perKmRate = perKmRate;
	}


	public int getCabId() {
		return cabId;
	}
	public void setCabId(int cabId) {
		this.cabId = cabId;
	}
	public carType getCarType() {
		return carType;
	}
	public void setCarType(carType carType) {
		this.carType = carType;
	}
	public float getPerKmRate() {
		return perKmRate;
	}
	public void setPerKmRate(float perKmRate) {
		this.perKmRate = perKmRate;
	}
	@Override
	public String toString() {
		return "Cab [cabId=" + cabId + ", carType=" + carType + ", perKmRate=" + perKmRate + "]";
	}
	
}
