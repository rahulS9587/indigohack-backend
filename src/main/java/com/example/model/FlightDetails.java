package com.example.model;


import java.util.Date;

import org.springframework.data.annotation.Id;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

@Entity
public class FlightDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String departure;
    private String arrival;
    private Date date;
    private String airportName;

   public FlightDetails(){
    	super();
    }
   public FlightDetails( Long id, String departure, String arrival, Date date,String airportName) {
	   this.id=id;
	   this.airportName=airportName;
	   this.date=date;
	   this.departure=departure;
	   this.arrival=arrival;
	   
   }
   public Long getId() {
       return id;
   }

   public String getDeparture() {
       return departure;
   }

   public String getArrival() {
       return arrival;
   }

   public Date getDate() {
       return date;
   }

   public String getAirportName() {
       return airportName;
   }

   // Setter methods

   public void setId(Long id) {
       this.id = id;
   }

   public void setDeparture(String departure) {
       this.departure = departure;
   }

   public void setArrival(String arrival) {
       this.arrival = arrival;
   }

   public void setDate(Date date) {
       this.date = date;
   }

   public void setAirportName(String airportName) {
       this.airportName = airportName;
   }
}
    


