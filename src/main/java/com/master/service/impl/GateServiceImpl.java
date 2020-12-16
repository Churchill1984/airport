package com.master.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.master.exception.GateNotFoundException;
import com.master.model.Gate;
import com.master.repository.GateRepository;
import com.master.service.GateService;

@Service
public class GateServiceImpl implements GateService {

	@Autowired
	private GateRepository gateRepository;

	@Override
	public Gate saveGate(Gate gate) {
		return gateRepository.save(gate);
	}

	@Override
	public Gate updateGate(Gate gate) {
		return gateRepository.saveAndFlush(gate);
	}

	@Override
	public void deleteGate(Gate gate) {
		gateRepository.delete(gate);
	}

	@Override
	public String deleteGateById(long id) {
		gateRepository.deleteById(id);
		return "Gate with id " + id + " deleted.";
	}

	@Override
	public List<Gate> listAllGates() {
		return gateRepository.findAll();
	}

	@Override
	public Gate getGate(long id) throws GateNotFoundException {
		Optional<Gate> gate = gateRepository.findById(id);
		if (gate.isPresent()) {
			return gate.get();
		} else {
			throw new GateNotFoundException(id);
		}
	}

}
