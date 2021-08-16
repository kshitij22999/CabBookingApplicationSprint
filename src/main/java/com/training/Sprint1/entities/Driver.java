package com.training.Sprint1.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
	

@Entity
@Table(name="cba_driver")
public class Driver extends User{ 
	
	private String driverName;
	private String lisenceNo;
	private float rating;
	
	@OneToOne(cascade = CascadeType.ALL)
	private Cab cab;
	
	@OneToMany(cascade = CascadeType.ALL)
	private List<TripBooking> tripbooking;
	
	@Enumerated
	private VaccinationStatus vaccinationStatus;
	
	@Enumerated
	private AvailabilityStatus availabilityStatus;
	
	
	public Driver() {
		// TODO Auto-generated constructor stub
	}




	public Driver(String username) {
		super(username);
		// TODO Auto-generated constructor stub
	}



	public Driver(long id, String username) {
		super(id, username);
		// TODO Auto-generated constructor stub
	}




	public Driver(long id) {
		super(id);
		// TODO Auto-generated constructor stub
	}

	


	public Driver(Long id, String driverName, String lisenceNo, float rating, Cab cab) {
		super(id);
		this.driverName = driverName;
		this.lisenceNo = lisenceNo;
		this.rating = rating;
		this.cab = cab;
	}




	public Driver(String driverName, String lisenceNo, float rating, Cab cab, VaccinationStatus vaccinationStatus) {
		super();
		this.driverName = driverName;
		this.lisenceNo = lisenceNo;
		this.rating = rating;
		this.cab = cab;
		this.vaccinationStatus = vaccinationStatus;
	}




	public Driver(Long id, String driverName, String lisenceNo, Cab cab, List<TripBooking> tripbooking) {
		super(id);
		this.driverName = driverName;
		this.lisenceNo = lisenceNo;
		this.cab = cab;
		this.tripbooking = tripbooking;
	}


	public Driver(long id, String username, String password, String mobileNumber, String email, String address) {

		super(id, username, password, mobileNumber, email, address);
		
		// TODO Auto-generated constructor stub
	}

	public Driver(String driverName, String lisenceNo, float rating, VaccinationStatus vaccinationStatus,
			AvailabilityStatus availabilityStatus) {
		super();
		this.driverName = driverName;
		this.lisenceNo = lisenceNo;
		this.rating = rating;
		this.vaccinationStatus = vaccinationStatus;
		this.availabilityStatus = availabilityStatus;
	}


	public Driver(String driverName, String lisenceNo, Cab cab) {
		super();
		this.driverName = driverName;
		this.lisenceNo = lisenceNo;
		this.cab = cab;
	}


	public String getDriverName() {
		return driverName;
	}


	public void setDriverName(String driverName) {
		this.driverName = driverName;
	}


	public String getLisenceNo() {
		return lisenceNo;
	}


	public void setLisenceNo(String lisenceNo) {
		this.lisenceNo = lisenceNo;
	}


	public float getRating() {
		return rating;
	}


	public void setRating(float rating) {
		this.rating = rating;
	}


	public Cab getCab() {
		return cab;
	}


	public void setCab(Cab cab) {
		this.cab = cab;
	}


	


	public List<TripBooking> getTripbooking() {
		return tripbooking;
	}


	public void setTripbooking(List<TripBooking> tripbooking) {
		this.tripbooking = tripbooking;
	}


	public VaccinationStatus getVaccinationStatus() {
		return vaccinationStatus;
	}


	public void setVaccinationStatus(VaccinationStatus vaccinationStatus) {
		this.vaccinationStatus = vaccinationStatus;
	}


	public AvailabilityStatus getAvailabilityStatus() {
		return availabilityStatus;
	}


	public void setAvailabilityStatus(AvailabilityStatus availabilityStatus) {
		this.availabilityStatus = availabilityStatus;
	}


	@Override
	public String toString() {
		return "Driver [driverName=" + driverName + ", lisenceNo=" + lisenceNo + ", rating=" + rating + ", cab=" + cab
				+ ", tripbooking=" + tripbooking + ", vaccinationStatus=" + vaccinationStatus + ", availabilityStatus="
				+ availabilityStatus + "]";
	}


}