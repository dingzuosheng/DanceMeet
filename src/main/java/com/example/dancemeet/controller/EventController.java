package com.example.dancemeet.controller;


import com.example.dancemeet.model.Party;
import com.example.dancemeet.model.Workshop;
import com.example.dancemeet.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/events")
public class EventController {
    private final EventService eventService;

    @Autowired
    public EventController(EventService eventService){
        this.eventService = eventService;
    }

    @GetMapping("/workshops")
    public ResponseEntity<List<Workshop>> getAllWorkshops(){
        List<Workshop> workshops = eventService.getAllWorkshops();
        return ResponseEntity.ok(workshops);
    }

    @PostMapping("/workshops")
    public ResponseEntity<Void> addWorkshop(@RequestBody Workshop workshop){
        eventService.addWorkshop(workshop);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/parties")
    public ResponseEntity<List<Party>> getAllParties(){
        List<Party> parties = eventService.getAllParties();
        return ResponseEntity.ok(parties);
    }

    @PostMapping("/parties")
    public ResponseEntity<Void> addParty(@RequestBody Party party){
        eventService.addParty(party);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/workshops/{workshopId}")
    public ResponseEntity<Void> deleteWorkshop(@PathVariable Long workshopId){
        eventService.deleteWorkshop(workshopId);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/parties/{partyId}")
    public ResponseEntity<Void> deleteParty(@PathVariable Long partyId){
        eventService.deleteParty(partyId);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/workshops/{workshopId}")
    public ResponseEntity<Workshop> getWorkshop(@PathVariable Long workshopId){
        Workshop workshop = eventService.getWorkshop(workshopId);
        return ResponseEntity.ok(workshop);
    }

    @GetMapping("/parties/{partyId}")
    public ResponseEntity<Party> getParty(@PathVariable Long partyId){
        Party party = eventService.getParty(partyId);
        return ResponseEntity.ok(party);
    }

}
