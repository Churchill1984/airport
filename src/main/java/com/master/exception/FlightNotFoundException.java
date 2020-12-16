package com.master.exception;

public class FlightNotFoundException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public FlightNotFoundException(Long id) {
		super("Could not find flight with this " + id);
	}
}
