package com.example.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Repository.passenger_repository;
import com.example.model.Passenger;

@Service
public class passenger_serviceImpl implements passenger_service {
	
	@Autowired
	passenger_repository passengerRepository;

	public Iterable<Passenger> getAllPassengers() {
        return passengerRepository.findAll();
    }

    public Optional<Passenger> getPassengerById(int passenger_id) {
        return passengerRepository.findById(passenger_id);
    }

    public Passenger createPassenger(Passenger passenger) {
        return passengerRepository.save(passenger);
    }

    public Optional<Passenger> updatePassenger(int passenger_id, Passenger updatedPassenger) {
        Optional<Passenger> passengerOptional = passengerRepository.findById(passenger_id);

        if (passengerOptional.isPresent()) {
            Passenger passenger = passengerOptional.get();
            passenger.setPassenger_age(updatedPassenger.getPassenger_age());
            passenger.setPassenger_name(updatedPassenger.getPassenger_name());
            passengerRepository.save(passenger);
            return Optional.of(passenger);
        } else {
            return Optional.empty();
        }
    }

    public void deletePassenger(int passenger_id) {
        passengerRepository.deleteById(passenger_id);
    }

	
}
	
	


