package com.master.exception;

public class GateNotFoundException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public GateNotFoundException(Long id) {
		super("Could not find gate with this " + id);
	}
}
