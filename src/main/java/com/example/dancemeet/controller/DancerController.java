package com.example.dancemeet.controller;


import com.example.dancemeet.dto.DancerDto;
import com.example.dancemeet.model.DanceSkill;
import com.example.dancemeet.model.Dancer;
import com.example.dancemeet.service.DancerSerivice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/dancers")
public class DancerController {
    private final DancerSerivice dancerSerivice;

    @Autowired
    public DancerController(DancerSerivice dancerSerivice){
        this.dancerSerivice = dancerSerivice;
    }

    @PostMapping("/register")
    public ResponseEntity<Dancer> register(@RequestBody DancerDto dancerDto){
        Dancer dancer = dancerSerivice.register(dancerDto);
        return ResponseEntity.ok(dancer);
    }

    @PostMapping("/login")
    public ResponseEntity<Dancer> login(@RequestParam String email, @RequestParam String password){
        Dancer dancer = dancerSerivice.login(email, password);
        return ResponseEntity.ok(dancer);
    }

    @GetMapping
    public ResponseEntity<List<Dancer>> getAllDancers(){
        List<Dancer> dancers = dancerSerivice.getAllDancers();
        return ResponseEntity.ok(dancers);
    }


    @GetMapping("/{dancerId}")
    public ResponseEntity<Dancer> getDancer(@PathVariable Long dancerId){
        Dancer dancer = dancerSerivice.getDancer(dancerId);
        return ResponseEntity.ok(dancer);
    }

    @PatchMapping("/{dancerId}/skills")
    public ResponseEntity<Dancer> updateSkills(@PathVariable Long dancerId, @RequestBody DanceSkill danceSkill){
        Dancer dancer = dancerSerivice.updateDancerSkill(dancerId, danceSkill);
        return ResponseEntity.ok(dancer);
    }

    @PatchMapping("/{dancerId}/coachSkills")
    public ResponseEntity<Dancer> updateCoachSkills(@PathVariable Long dancerId, @RequestBody DanceSkill danceSkill){
        Dancer dancer = dancerSerivice.updateDancerCoachSkill(dancerId, danceSkill);
        return ResponseEntity.ok(dancer);
    }

}
