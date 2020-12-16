package com.master.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.master.exception.FlightNotFoundException;
import com.master.model.Flight;
import com.master.repository.FlightRepository;
import com.master.service.FlightService;

public class FlightServiceImpl implements FlightService {
	
	@Autowired
	private FlightRepository flightRepository;

	@Override
	public Flight saveFlight(Flight flight) {
		return flightRepository.save(flight);
	}

	@Override
	public Flight updateFlight(Flight flight) {
		return flightRepository.saveAndFlush(flight);
	}

	@Override
	public void deleteFlight(Flight flight) {
		flightRepository.delete(flight);
	}

	@Override
	public String deleteFlightById(long id) {
		flightRepository.deleteById(id);
		return "Flight with id " + id + " deleted.";
	}

	@Override
	public List<Flight> listAllFlights() {
		return flightRepository.findAll();
	}

	@Override
	public Flight findFlightByFlightNumber(String flightNumber) {
		return flightRepository.findFlightByFlightNumber(flightNumber);
	}

	@Override
	public Flight getFlight(long id) throws FlightNotFoundException {
		Optional<Flight> flight = flightRepository.findById(id);
		if (flight.isPresent()) {
			return flight.get();
		} else {
			throw new FlightNotFoundException(id);
		}
	}

}
