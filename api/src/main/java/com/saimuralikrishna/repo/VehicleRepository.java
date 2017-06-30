package com.saimuralikrishna.repo;

import com.saimuralikrishna.entities.Vehicle;

import java.util.List;

/**
 * Created by saimuralikrishnasriadibhatla on 6/28/17.
 */
public interface VehicleRepository {
    public List<Vehicle> getAll();
    public Vehicle findByVin(String id);
    public Vehicle createVehicle(Vehicle vehicle);
    public Vehicle updateVehicle(Vehicle vehicle);
}