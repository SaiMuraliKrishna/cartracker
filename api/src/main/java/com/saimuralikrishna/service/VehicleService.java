package com.saimuralikrishna.service;

import com.saimuralikrishna.entities.Vehicle;

import java.util.List;

/**
 * Created by saimuralikrishnasriadibhatla on 6/28/17.
 */
public interface VehicleService {
    public List<Vehicle> getAll();
    public Vehicle findByVin(String id);
    public Vehicle createVehicle(Vehicle vehicle);
    public Vehicle updateVehicle(Vehicle vehicle);
}