package edu.miu.cs.flightreservation.service;

import edu.miu.cs.flightreservation.model.Flight;

import java.util.List;

public interface FlightService {
    public List<Flight> findAll();
    public Flight findById(long id);
    public Flight update(long id);
    public Flight create(Flight flight);
}
