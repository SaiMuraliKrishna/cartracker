package com.saimuralikrishna.repo.impl;

import com.saimuralikrishna.entities.Tire;
import com.saimuralikrishna.repo.TireRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Created by saimuralikrishnasriadibhatla on 6/28/17.
 */
@Repository
public class TireRepositoryImpl implements TireRepository {

    @PersistenceContext
    private EntityManager em;

    @Override
    public Tire createTire(Tire tire) {
        em.persist(tire);
        return tire;
    }
}