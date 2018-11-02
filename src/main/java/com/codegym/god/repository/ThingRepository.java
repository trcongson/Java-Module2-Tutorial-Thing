package com.codegym.god.repository;

import com.codegym.god.model.Thing;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ThingRepository extends PagingAndSortingRepository<Thing, Long> {
}
