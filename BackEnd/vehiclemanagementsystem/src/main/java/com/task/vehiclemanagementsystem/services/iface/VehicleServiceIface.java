package com.task.vehiclemanagementsystem.services.iface;

import java.util.List;

import com.task.vehiclemanagementsystem.model.Vehicle;

public interface VehicleServiceIface {
    List<Vehicle> getAllVehicles();
    Vehicle getVehicleById(Long id);
    Vehicle createVehicle(Vehicle vehicle);
    Vehicle updateVehicle(Long id, Vehicle vehicle);
    void deleteVehicle(Long id);
}
