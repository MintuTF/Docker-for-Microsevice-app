package edu.miu.cs.flightreservation.controller;

import edu.miu.cs.flightreservation.model.Airline;
import edu.miu.cs.flightreservation.model.Airport;
import edu.miu.cs.flightreservation.service.AirportServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/airports")
public class AirportController {
    @Autowired
    private AirportServiceImpl airportService;

    @GetMapping()
    public ResponseEntity<List<Airport>> getAirportsByPage(){
        List<Airport> airports = airportService.findAll();
        return new ResponseEntity<>(airports, HttpStatus.OK);
    }

    @GetMapping(params = "page=true")
    public ResponseEntity<Page<Airport>> getAirportsByPage(Pageable pageable){
        Page<Airport> airports = airportService.findAll(pageable);
        return new ResponseEntity<>(airports, HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<Airport> createAirport(@RequestBody Airport airport){
        try{
            Airport _airport = new Airport();
            _airport.setName(airport.getName());
            return new ResponseEntity(airportService.save(airport), HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Airport> getAirportById(@PathVariable("id") Long id){
        Airport _airport = airportService.findById(id);
        if(_airport != null){
            return new ResponseEntity<>(_airport, HttpStatus.OK);
        }else
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Airport> updateAirport(@PathVariable("id") Long id, @RequestBody Airport airport){
        Airport _airport = airportService.findById(id);
        if(airport != null){
            _airport.setName(airport.getName());
            return new ResponseEntity<>(airportService.save(_airport), HttpStatus.OK);
        }else
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteAirport(@PathVariable("id") Long id){
        Airport airport = airportService.findById(id);
        if(airport != null){
            airportService.delete(airport);
            return new ResponseEntity<>(HttpStatus.OK);
        }else
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }
}
