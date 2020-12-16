package com.master.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.master.model.Flight;

@Repository
public interface FlightRepository extends JpaRepository<Flight, Long> {

	@Query(value = "SELECT f FROM flights f WHERE f.flight_number = :flightNumber", nativeQuery = true)
    public Flight findFlightByFlightNumber(@Param("flightNumber") String flightNumber);
}
