package com.task.vehiclemanagementsystem.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.task.vehiclemanagementsystem.model.Vehicle;

@EnableJpaRepositories
public interface VehicleRepository extends JpaRepository<Vehicle, Long> {

}
