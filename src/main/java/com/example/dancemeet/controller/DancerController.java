package com.example.dancemeet.controller;


import com.example.dancemeet.dto.DancerDto;
import com.example.dancemeet.model.Dancer;
import com.example.dancemeet.service.DancerSerivice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class DancerController {
    private DancerSerivice dancerSerivice;

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

    @PostMapping("/event")
    public ResponseEntity<Void> joinEvent(@RequestParam Long dancerId, @RequestParam Long eventId){
        dancerSerivice.joinEvent(dancerId, eventId);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/dancers")
    public ResponseEntity<List<Dancer>> getAllDancers(){
        List<Dancer> dancers = dancerSerivice.getAllDancers();
        return ResponseEntity.ok(dancers);
    }


}
