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
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long cabId;
	

	private CarType carType;

	private float perKmRate;
	
	public Cab() {
		super();
		// TODO Auto-generated constructor stub
	}

<<<<<<< HEAD
	public Cab(Long cabId, com.training.Sprint1.entities.CarType carType, float perKmRate) {
=======
	public Cab(Long cabId, com.training.Sprint1.entities.carType carType, float perKmRate) {
>>>>>>> 3f78c0ae3dea4d2a27cc58bc35e07772819557f4
		super();
		this.cabId = cabId;
		this.carType = carType;
		this.perKmRate = perKmRate;
	}

<<<<<<< HEAD
	public Cab(com.training.Sprint1.entities.CarType carType, float perKmRate) {
=======
	public Cab(com.training.Sprint1.entities.carType carType, float perKmRate) {
>>>>>>> 3f78c0ae3dea4d2a27cc58bc35e07772819557f4
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

<<<<<<< HEAD
	public CarType getCarType() {
		return carType;
	}

	public void setCarType(CarType carType) {
=======
	public carType getCarType() {
		return carType;
	}

	public void setCarType(carType carType) {
>>>>>>> 3f78c0ae3dea4d2a27cc58bc35e07772819557f4
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
