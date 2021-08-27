package edu.miu.cs.flightreservation.service;

import edu.miu.cs.flightreservation.model.Flight;
import edu.miu.cs.flightreservation.repository.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
@Service
public class FlightServiceImpl implements FlightService{
    @Autowired
    private FlightRepository repository;

    @Override
    public List<Flight> findAll() {
        List<Flight> flights = repository.findAll();
        Collections.sort(flights, Comparator.comparing(Flight::getNumber));
        return flights;
    }

    @Override
    public Flight findById(long id) {
        return repository.findById(id).get();
    }

    @Override
    public Flight update(long id) {
        Boolean exist = repository.existsById(id);
        if (exist){
            return repository.save(repository.getById(id));
        }
        return null;
    }

    @Override
    public Flight create(Flight flight) {
        return repository.save(flight);
    }
}
