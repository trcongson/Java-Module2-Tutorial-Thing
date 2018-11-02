package com.codegym.god.service;

import com.codegym.god.model.Thing;

public interface ThingService {
    Iterable<Thing> findAll();

    Thing findById(Long id);

    void save(Thing thing);

    void remove(Long id);
}
