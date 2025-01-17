package com.task.vehiclemanagementsystem.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.task.vehiclemanagementsystem.model.Vehicle;
import com.task.vehiclemanagementsystem.repositories.VehicleRepository;
import com.task.vehiclemanagementsystem.services.iface.VehicleServiceIface;

import jakarta.transaction.Transactional;

@Service
public class VehicleServiceImpl implements VehicleServiceIface {

    @Autowired
    private VehicleRepository vehicleRepository;

    @Override
    public List<Vehicle> getAllVehicles() {
        return vehicleRepository.findAll();
    }

    @Override
    public Vehicle getVehicleById(Long id) {
        Optional<Vehicle> optionalVehicle = vehicleRepository.findById(id);
        return optionalVehicle.orElse(null);
    }

    @Override
    public Vehicle createVehicle(Vehicle vehicle) {
        return vehicleRepository.save(vehicle);
    }

    @Override
    @Transactional
    public Vehicle updateVehicle(Long id, Vehicle updatedVehicle) {
        Optional<Vehicle> optionalVehicle = vehicleRepository.findById(id);
        if (optionalVehicle.isPresent()) {
            updatedVehicle.setId(id);
            return vehicleRepository.save(updatedVehicle);
        } else {
            return null;
        }
    }

    @Override
    @Transactional
    public void deleteVehicle(Long id) {
        vehicleRepository.deleteById(id);
    }
}
