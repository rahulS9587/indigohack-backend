package com.example.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.Passenger;
import com.example.service.passenger_serviceImpl;

@RestController
@RequestMapping("/passengers")
public class passenger_controller {
	
	@Autowired
	passenger_serviceImpl passengerService;
	
	 @GetMapping
	    public Iterable<Passenger> getAllPassengers() {
	        return passengerService.getAllPassengers();
	    }

	    @GetMapping("/{id}")
	    public Object getPassengerById(@PathVariable int id) {
	        Optional<Passenger> passenger = passengerService.getPassengerById(id);
	        return passenger.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
	                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
	    }

	    @PostMapping
	    public Passenger createPassenger(@RequestBody Passenger passenger) {
	        return passengerService.createPassenger(passenger);
	    }

	    @PutMapping("/{id}")
	    public ResponseEntity<Passenger> updatePassenger(@PathVariable int id, @RequestBody Passenger passenger) {
	        Optional<Passenger> updatedPassenger = passengerService.updatePassenger(id, passenger);
	        return updatedPassenger.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
	                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
	    }

	    @DeleteMapping("/{id}")
	    public void deletePassenger(@PathVariable int id) {
	        passengerService.deletePassenger(id);
	    }
	}


