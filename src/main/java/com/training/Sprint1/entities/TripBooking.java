package com.training.Sprint1.entities;

import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@SuppressWarnings("unused")
enum Status{ALLOCATED,NOT_ALLOCATED}

@Entity
@Table(name="cba_tripbooking")
public class TripBooking {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@ManyToOne
	private Driver driver;
	
	@ManyToOne(cascade = CascadeType.ALL)
	private Customer customer;
	
	@ManyToOne(cascade = CascadeType.ALL)
	private Cab cab;
	
	private String fromLocation;
	private String toLocation;
	
	private LocalDateTime fromDateTime;
	private LocalDateTime toDateTime;
	private Status status;
	private float distanceInKm;
	private float bill;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getFromLocation() {
		return fromLocation;
	}
	public void setFromLocation(String fromLocation) {
		this.fromLocation = fromLocation;
	}
	public String getToLocation() {
		return toLocation;
	}
	public void setToLocation(String toLocation) {
		this.toLocation = toLocation;
	}
	public LocalDateTime getFromDateTime() {
		return fromDateTime;
	}
	public void setFromDateTime(LocalDateTime fromDateTime) {
		this.fromDateTime = fromDateTime;
	}
	public LocalDateTime getToDateTime() {
		return toDateTime;
	}
	public void setToDateTime(LocalDateTime toDateTime) {
		this.toDateTime = toDateTime;
	}
	public Status getStatus() {
		return status;
	}
	public void setStatus(Status status) {
		this.status = status;
	}
	public float getDistanceInKm() {
		return distanceInKm;
	}
	public void setDistanceInKm(float distanceInKm) {
		this.distanceInKm = distanceInKm;
	}
	public float getBill() {
		return bill;
	}
	public void setBill(float bill) {
		this.bill = bill;
	}
	public Driver getDriver() {
		return driver;
	}
	public Customer getCustomer() {
		return customer;
	}
	public Cab getCab() {
		return cab;
	}
	@Override
	public String toString() {
		return "TripBooking [id=" + id + ", driver=" + driver + ", fromLocation=" + fromLocation + ", toLocation="
				+ toLocation + ", fromDateTime=" + fromDateTime + ", toDateTime=" + toDateTime + ", status=" + status
				+ ", distanceInKm=" + distanceInKm + ", bill=" + bill + "]";
	}
	public TripBooking(long id, Driver driver, String fromLocation, String toLocation, LocalDateTime fromDateTime,
			LocalDateTime toDateTime, Status status, float distanceInKm, float bill) {
		super();
		this.id = id;
		this.driver = driver;
		this.fromLocation = fromLocation;
		this.toLocation = toLocation;
		this.fromDateTime = fromDateTime;
		this.toDateTime = toDateTime;
		this.status = status;
		this.distanceInKm = distanceInKm;
		this.bill = bill;
	}
	
	
}