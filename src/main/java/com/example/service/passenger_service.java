package com.example.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.model.Passenger;

@Service
public interface passenger_service {
	
	public Passenger createPassenger(Passenger passenger);
	 public void deletePassenger(int passenger_id);
	
	public Optional<Passenger> getPassengerById(int passenger_id);
	public Optional<Passenger> updatePassenger(int passenger_id, Passenger updatedPassenger);
	

}
