package com.training.Sprint1.entities;

import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.ForeignKey;
import org.hibernate.annotations.ManyToAny;



@Entity
@Table(name="cba_tripbooking5")
public class TripBooking {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@ForeignKey(name = "tripId")
	private Long id;
	

	
	@ManyToOne(targetEntity = Customer.class)
	private Customer customer;
	
	@ManyToOne(cascade = CascadeType.ALL)
	private Cab cab;
	
	@ManyToOne
	private Driver driver;

	private String fromLocation;
	private String toLocation;
	
	private LocalDateTime fromDateTime;
	private LocalDateTime toDateTime;
	
	@Enumerated(EnumType.STRING)
	private Status status;
	
	private float distanceInKm;
	private float bill;
	
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public void setCab(Cab cab) {
		this.cab = cab;
	}
	public void setDriver(Driver driver) {
		this.driver = driver;
	}
	
	
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
		return "TripBooking [id=" + id + ", driver=" + driver + ", customer=" + customer + ", cab=" + cab
				+ ", fromLocation=" + fromLocation + ", toLocation=" + toLocation + ", fromDateTime=" + fromDateTime
				+ ", toDateTime=" + toDateTime + ", status=" + status + ", distanceInKm=" + distanceInKm + ", bill="
				+ bill + "]";
	}
	public TripBooking(Long id, Driver driver, Customer customer, Cab cab, String fromLocation, String toLocation,
			LocalDateTime fromDateTime, LocalDateTime toDateTime, Status status, float distanceInKm, float bill) {
		super();
		this.id = id;
		this.driver = driver;
		this.customer = customer;
		this.cab = cab;
		this.fromLocation = fromLocation;
		this.toLocation = toLocation;
		this.fromDateTime = fromDateTime;
		this.toDateTime = toDateTime;
		this.status = status;
		this.distanceInKm = distanceInKm;
		this.bill = bill;
	}
	public TripBooking(Long id) {
		super();
		this.id = id;
	}
	public TripBooking(Driver driver, Customer customer, Cab cab) {
		super();
		this.driver = driver;
		this.customer = customer;
		this.cab = cab;
	}
	public TripBooking(Status status) {
		super();
		this.status = status;
	}
	public TripBooking(Long id, Status status) {
		super();
		this.id = id;
		this.status = status;
	}
	public TripBooking() {
		super();
		// TODO Auto-generated constructor stub
	}
	public TripBooking( Status status, float distanceInKm, float bill) {
		super();
		this.status = status;
		this.distanceInKm = distanceInKm;
		this.bill = bill;
	}
	public TripBooking(Customer customer, String fromLocation, String toLocation, Status status, float distanceInKm) {
		super();
		this.customer = customer;
		this.fromLocation = fromLocation;
		this.toLocation = toLocation;
		this.status = status;
		this.distanceInKm = distanceInKm;
	}
	public TripBooking(String fromLocation, String toLocation) {
		super();
		this.fromLocation = fromLocation;
		this.toLocation = toLocation;
	}
	public TripBooking(String fromLocation, String toLocation, float distanceInKm) {
		super();
		this.fromLocation = fromLocation;
		this.toLocation = toLocation;
		this.distanceInKm = distanceInKm;
	}
	
	
	
}