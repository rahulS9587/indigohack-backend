package com.example.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Passenger {

	@Id
	private int passenger_id;

	private String passenger_name;

	private int passenger_age;

	@ManyToOne
	@JoinColumn(name = "flight_details_id")
	private FlightDetails flightDetails;

	public Passenger() {
		super();

	}

	public Passenger(int passenger_id, String passenger_name, int passenger_age) {
		super();
		this.passenger_id = passenger_id;
		this.passenger_name = passenger_name;
		this.passenger_age = passenger_age;

	}

	public int getPassenger_id() {
		return passenger_id;
	}

	public void setPassenger_id(int passenger_id) {
		this.passenger_id = passenger_id;
	}

	public String getPassenger_name() {
		return passenger_name;
	}

	public void setPassenger_name(String passenger_name) {
		this.passenger_name = passenger_name;
	}

	public int getPassenger_age() {
		return passenger_age;
	}

	public void setPassenger_age(int passenger_age) {
		this.passenger_id = passenger_age;
	}

}
