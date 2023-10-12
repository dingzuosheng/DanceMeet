package com.example.dancemeet.repository;


import com.example.dancemeet.model.DanceSkill;
import com.example.dancemeet.model.DanceType;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface DanceSkillRepository extends CrudRepository<DanceSkill, DanceType> {
    Optional<DanceSkill> findByName(DanceType name);
}
