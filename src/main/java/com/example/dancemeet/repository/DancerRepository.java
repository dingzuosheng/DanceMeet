package com.example.dancemeet.repository;


import com.example.dancemeet.model.Dancer;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface DancerRepository extends CrudRepository<Dancer,Long> {
    Optional<Dancer> findByEmail(String email);
}
