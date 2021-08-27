package edu.miu.cs.flightreservation.controller;

import edu.miu.cs.flightreservation.model.Address;
import edu.miu.cs.flightreservation.service.AddressServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/addresses")
public class AddressController {
//    @Autowired
//    private AddressServiceImpl addressService;
//
//    @GetMapping()
//    public ResponseEntity<List<Address>> getAddressesByPage(){
//        List<Address> addresses = addressService.findAll();
//        return new ResponseEntity<>(addresses, HttpStatus.OK);
//    }
//
//    @GetMapping(params = "page=true")
//    public ResponseEntity<Page<Address>> getAddressesByPage(Pageable pageable){
//        Page<Address> addresses = addressService.findAll(pageable);
//        return new ResponseEntity<>(addresses, HttpStatus.OK);
//    }
//
//    @PostMapping()
//    public ResponseEntity<Address> createAirline(@RequestBody Address address){
//        try{
//            Address _address = new Address();
//            _address.setCity(address.getCity());
//            _address.setState(address.getState());
//            _address.setStreet(address.getStreet());
//            _address.setZip(address.getZip());
//            return new ResponseEntity(addressService.save(_address), HttpStatus.CREATED);
//        }catch (Exception e){
//            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//    }
//
//    @GetMapping("/{id}")
//    public ResponseEntity<Address> getAddressById(@PathVariable("id") Long id){
//        Address _address = addressService.findById(id);
//        if(_address != null){
//            return new ResponseEntity<>(_address, HttpStatus.OK);
//        }else
//            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
//    }
//
//    @PutMapping("/{id}")
//    public ResponseEntity<Address> updateAirline(@PathVariable("id") Long id, @RequestBody Address address){
//        Address _address = addressService.findById(id);
//        if(_address != null){
//                _address.setCity(address.getCity());
//                _address.setState(address.getState());
//                _address.setStreet(address.getStreet());
//                _address.setZip(address.getZip());
//                return new ResponseEntity<>(addressService.save(_address), HttpStatus.OK);
//        }else
//            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
//    }
//
//    @DeleteMapping("/{id}")
//    public ResponseEntity<HttpStatus> deleteAirline(@PathVariable("id") Long id){
//        Address _address = addressService.findById(id);
//        if(_address != null){
//            addressService.delete(_address);
//            return new ResponseEntity<>(HttpStatus.OK);
//        }else
//            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
//    }
}
