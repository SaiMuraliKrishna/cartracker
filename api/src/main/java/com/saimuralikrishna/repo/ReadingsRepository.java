package com.saimuralikrishna.repo;

import com.saimuralikrishna.entities.Reading;
import com.saimuralikrishna.pojo.VehicleReading;

import java.util.List;

/**
 * Created by saimuralikrishnasriadibhatla on 6/28/17.
 */
public interface ReadingsRepository {
    public List<Reading> findAll();
    public List<Reading> findByVin(String vin);
    public Reading createReading(Reading reading);
    public List<VehicleReading> getAlerts(String key);
    public List<Reading> getReadingsByVinWithTimeDuration(String vin, int time, String unit);
}