package com.codegym.god.service.Impl;

import com.codegym.god.model.Thing;
import com.codegym.god.repository.ThingRepository;
import com.codegym.god.service.ThingService;
import org.springframework.beans.factory.annotation.Autowired;

public class ThingServiceImpl implements ThingService {

    @Autowired
    private ThingRepository thingRepository;

    @Override
    public Iterable<Thing> findAll() {
        return thingRepository.findAll();
    }

    @Override
    public Thing findById(Long id) {
        return thingRepository.findOne(id);
    }

    @Override
    public void save(Thing thing) {
        thingRepository.save(thing);
    }

    @Override
    public void remove(Long id) {
        thingRepository.delete(id);
    }
}
