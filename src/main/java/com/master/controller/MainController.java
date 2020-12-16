package com.master.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.master.exception.GateNotFoundException;
import com.master.model.Flight;
import com.master.model.Gate;
import com.master.service.FlightService;
import com.master.service.GateService;

@RestController
public class MainController {

	private GateService gateService;
	private FlightService flightService;

	@Autowired
	public MainController(GateService gateService, FlightService flightService) {
		this.gateService = gateService;
		this.flightService = flightService;
	}

	// Get All Gates
	@GetMapping("/gates")
	public List<Gate> getAllGates() {
		return gateService.listAllGates();
	}

	// Get a Gate by flight number
	@GetMapping("/flights/{flightNumber}")
	public Gate getGateByFlightNumber(@PathVariable(value = "flightNumber") String flightNumber) {
		Flight flight = flightService.findFlightByFlightNumber(flightNumber);
		return flight.getGate();
	}

	// Update a Gate
	@PutMapping("/gates/{id}")
	public Gate updateNote(@PathVariable(value = "id") Long gateId, @Valid @RequestBody Gate gateDetails)
			throws GateNotFoundException {

		Gate gate = gateService.getGate(gateId);
		gate.setAvailable(gateDetails.isAvailable());

		Gate updatedGate = gateService.updateGate(gate);

		return updatedGate;
	}

}
