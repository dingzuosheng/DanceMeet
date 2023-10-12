package com.example.dancemeet.repository;


import com.example.dancemeet.model.DanceSkill;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface DanceSkillRepository extends CrudRepository<DanceSkill, String> {
    Optional<DanceSkill> findByName(String name);
}
