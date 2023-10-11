package com.example.dancemeet.repository;


import com.example.dancemeet.model.Event;
import org.springframework.data.repository.CrudRepository;

public interface EventRepository extends CrudRepository<Event, Long> {
}
