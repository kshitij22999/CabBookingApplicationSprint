package com.training.Sprint1.entities;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name="cba_cab5")
public class Cab {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long cabId;
	

	@OneToOne(mappedBy = "cab")
	private Driver driver;
	@Enumerated
	private CarType carType;
	
	private float perKmRate;
	
	public Cab() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Cab(Long cabId, com.training.Sprint1.entities.CarType carType, float perKmRate) {
		super();
		this.cabId = cabId;
		this.carType = carType;
		this.perKmRate = perKmRate;
	}

	public Cab(com.training.Sprint1.entities.CarType carType, float perKmRate) {
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
