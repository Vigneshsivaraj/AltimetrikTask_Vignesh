package com.task.vehiclemanagementsystem.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.task.vehiclemanagementsystem.exceptions.ResourceNotFoundException;
import com.task.vehiclemanagementsystem.model.Vehicle;
import com.task.vehiclemanagementsystem.services.iface.VehicleServiceIface;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/vms")
@CrossOrigin(origins = "*")
public class VehicleController { 
	
	   @Autowired
	    private VehicleServiceIface vehicleService;

	   @GetMapping("/hello")
	   public String helloworld() {
		   return "hello VMS";
	   }
	   
	    @GetMapping
	    public ResponseEntity<List<Vehicle>> getAllVehicles() {
	        List<Vehicle> vehicles = vehicleService.getAllVehicles();
	        return new ResponseEntity<>(vehicles, HttpStatus.OK);
	    }

	    @GetMapping("/{id}")
	    public ResponseEntity<Vehicle> getVehicleById(@PathVariable("id") Long id) {
	        Vehicle vehicle = vehicleService.getVehicleById(id);
	        if (vehicle == null) {
	            throw new ResourceNotFoundException("Vehicle not found with id: " + id);
	        }
	        return new ResponseEntity<>(vehicle, HttpStatus.OK);
	    }

	    @PostMapping
	    public ResponseEntity<Vehicle> createVehicle(@Valid @RequestBody Vehicle vehicle) { 
	        Vehicle createdVehicle = vehicleService.createVehicle(vehicle);
	        return new ResponseEntity<>(createdVehicle, HttpStatus.CREATED);
	    }

	    @PutMapping("/{id}")
	    public ResponseEntity<Vehicle> updateVehicle(@PathVariable("id") Long id, @Valid @RequestBody Vehicle vehicle) { 
	        Vehicle updatedVehicle = vehicleService.updateVehicle(id, vehicle);
	        if (updatedVehicle == null) {
	            throw new ResourceNotFoundException("Vehicle not found with id: " + id);
	        }
	        return new ResponseEntity<>(updatedVehicle, HttpStatus.OK);
	    }

	    @DeleteMapping("/{id}")
	    public ResponseEntity<Void> deleteVehicle(@PathVariable("id") Long id) {
	        vehicleService.deleteVehicle(id);
	        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	    }
}
