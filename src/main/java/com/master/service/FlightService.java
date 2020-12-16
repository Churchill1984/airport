package com.master.service;

import java.util.List;

import com.master.exception.FlightNotFoundException;
import com.master.model.Flight;

public interface FlightService {

	public Flight saveFlight(Flight flight);

	public Flight updateFlight(Flight flight);

	public void deleteFlight(Flight flight);

	public String deleteFlightById(long id);

	public List<Flight> listAllFlights();
	
	public Flight findFlightByFlightNumber(String flightNumber);
	
	public Flight getFlight(long id) throws FlightNotFoundException;
}
