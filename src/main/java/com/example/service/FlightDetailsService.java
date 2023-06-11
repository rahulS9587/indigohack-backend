package com.example.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.Repository.FlightDetailsRepository;
import com.example.model.FlightDetails;

public class FlightDetailsService {
	
	
	@Autowired
	FlightDetailsRepository flightDetailsRepository;
	  public Iterable<FlightDetails> getAllFlightDetails() {
	        return flightDetailsRepository.findAll();
	    }

	    public Optional<FlightDetails> getFlightDetailsById(Long id) {
	        return flightDetailsRepository.findById(id);
	    }

	    public FlightDetails createFlightDetails(FlightDetails flightDetails) {
	        return flightDetailsRepository.save(flightDetails);
	    }

	    public Optional<FlightDetails> updateFlightDetails(Long id, FlightDetails updatedFlightDetails) {
	        Optional<FlightDetails> flightDetailsOptional = flightDetailsRepository.findById(id);

	        if (flightDetailsOptional.isPresent()) {
	            FlightDetails flightDetails = flightDetailsOptional.get();
	            flightDetails.setDeparture(updatedFlightDetails.getDeparture());
	            flightDetails.setArrival(updatedFlightDetails.getArrival());
	            flightDetails.setDate(updatedFlightDetails.getDate());
	            flightDetails.setAirportName(updatedFlightDetails.getAirportName());
	            flightDetailsRepository.save(flightDetails);
	            return Optional.of(flightDetails);
	        } else {
	            return Optional.empty();
	        }
	    }

	    public void deleteFlightDetails(Long id) {
	        flightDetailsRepository.deleteById(id);
	    }
	}


