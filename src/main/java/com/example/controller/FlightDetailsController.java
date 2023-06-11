package com.example.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import com.example.model.FlightDetails;
import com.example.service.FlightDetailsService;

@RestController
@RequestMapping("/flight-details")
public class FlightDetailsController {
	

	@Autowired
	FlightDetailsService flightDetailsService;
	

	@GetMapping
	public Iterable<FlightDetails> getAllFlightDetails() {
		return flightDetailsService.getAllFlightDetails();
	}

	@GetMapping("/{id}")
	public ResponseEntity<FlightDetails> getFlightDetailsById(@PathVariable Long id) {
		return flightDetailsService.getFlightDetailsById(id)
				.map(flightDetails -> new ResponseEntity<>(flightDetails, HttpStatus.OK))
				.orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
	}

	@PostMapping
	public FlightDetails createFlightDetails(@RequestBody FlightDetails flightDetails) {
		return flightDetailsService.createFlightDetails(flightDetails);
	}

	@PutMapping("/{id}")
	    public Optional<FlightDetails> updateFlightDetails(@PathVariable Long id, @RequestBody FlightDetails flightDetails) {
	        Optional<FlightDetails> updatedFlightDetails = flightDetailsService.updateFlightDetails(id, flightDetails);
			return updatedFlightDetails;
			

}
}