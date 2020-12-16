package com.master.service;

import java.util.List;

import com.master.exception.GateNotFoundException;
import com.master.model.Gate;

public interface GateService {

	public Gate saveGate(Gate gate);

	public Gate updateGate(Gate gate);

	public void deleteGate(Gate gate);

	public String deleteGateById(long id);

	public List<Gate> listAllGates();
	
	public Gate getGate(long id) throws GateNotFoundException;
}
