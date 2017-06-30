package com.saimuralikrishna.service.impl;

import com.saimuralikrishna.entities.Tire;
import com.saimuralikrishna.repo.TireRepository;
import com.saimuralikrishna.service.TireService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by saimuralikrishnasriadibhatla on 6/28/17.
 */
@Service
public class TireServiceImpl implements TireService {

    private TireRepository tireRepository;

    public TireServiceImpl(TireRepository tireRepository){
        this.tireRepository = tireRepository;
    }

    @Override
    @Transactional
    public Tire createTire(Tire tire) {
        return tireRepository.createTire(tire);
    }
}