package com.saimuralikrishna.repo.impl;

import com.saimuralikrishna.entities.Vehicle;
import com.saimuralikrishna.repo.VehicleRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

/**
 * Created by saimuralikrishnasriadibhatla on 6/28/17.
 */

@Repository
public class VehicleRepositoryImpl implements VehicleRepository {
    @PersistenceContext
    private EntityManager em;

    @Override
    public List<Vehicle> getAll() {
        TypedQuery<Vehicle> query = em.createNamedQuery("Vhcl.findAll", Vehicle.class);
        return query.getResultList();
    }

    @Override
    public Vehicle findByVin(String id) {
        TypedQuery<Vehicle> query = em.createNamedQuery("Vhcl.findByVin", Vehicle.class);
        query.setParameter("pVin", id);
        List<Vehicle> vehicles = query.getResultList();
        if(!vehicles.isEmpty()){
            return vehicles.get(0);
        }
        return null;
    }

    @Override
    public Vehicle createVehicle(Vehicle vehicle) {
        em.persist(vehicle);
        return vehicle;
    }

    @Override
    public Vehicle updateVehicle(Vehicle vehicle) {
        return em.merge(vehicle);
    }
}