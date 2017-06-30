package com.saimuralikrishna.pojo;

import com.saimuralikrishna.entities.Reading;
import com.saimuralikrishna.entities.Vehicle;

/**
 * Created by saimuralikrishnasriadibhatla on 6/28/17.
 */
public class VehicleReading {
    private Reading reading;
    private Vehicle vehicle;

    public VehicleReading(Reading reading, Vehicle vehicle) {
        this.reading = reading;
        this.vehicle = vehicle;
    }

    public Reading getReading() {
        return reading;
    }

    public void setReading(Reading reading) {
        this.reading = reading;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }
}
