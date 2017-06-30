package com.saimuralikrishna.service.impl;

import com.saimuralikrishna.entities.Reading;
import com.saimuralikrishna.entities.Tire;
import com.saimuralikrishna.entities.Vehicle;
import com.saimuralikrishna.exceptions.VehicleNotFoundException;
import com.saimuralikrishna.pojo.VehicleReading;
import com.saimuralikrishna.repo.ReadingsRepository;
import com.saimuralikrishna.repo.TireRepository;
import com.saimuralikrishna.service.ReadingsService;
import com.saimuralikrishna.service.TireService;
import com.saimuralikrishna.service.VehicleService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


/**
 * Created by saimuralikrishnasriadibhatla on 6/28/17.
 */

@Service
public class ReadingsServiceImpl implements ReadingsService {

    private ReadingsRepository readingsRepository;
    private TireService tireService;
    private VehicleService vehicleService;
    public ReadingsServiceImpl(ReadingsRepository readingsRepository, TireService tireService, VehicleService vehicleService){
        this.readingsRepository = readingsRepository;
        this.tireService = tireService;
        this.vehicleService = vehicleService;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Reading> findAll() {
        return this.readingsRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public List<Reading> findByVin(String vin) {
        return this.readingsRepository.findByVin(vin);
    }

    @Override
    @Transactional
    public Reading createReading(Reading reading) {
        Vehicle existingVehicle = this.vehicleService.findByVin(reading.getVin());
        if(existingVehicle == null){
            throw new VehicleNotFoundException("Vehicle with VIN: "+reading.getVin()+" doesn't exists.");
        }
        Tire tire = this.tireService.createTire(reading.getTires());
        return readingsRepository.createReading(reading);
    }

    @Override
    @Transactional
    public List<VehicleReading> getAlerts(String key) {
        return readingsRepository.getAlerts(key);
    }

    @Override
    @Transactional
    public List<Reading> getReadingsByVinWithTimeDuration(String vin, int time, String unit) {
        return readingsRepository.getReadingsByVinWithTimeDuration(vin, time, unit);
    }
}
