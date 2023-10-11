package com.example.dancemeet.controller;


import com.example.dancemeet.model.Party;
import com.example.dancemeet.model.Workshop;
import com.example.dancemeet.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/events")
public class EventController {
    private final EventService eventService;

    @Autowired
    public EventController(EventService eventService){
        this.eventService = eventService;
    }

    @PostMapping("/workshops")
    public ResponseEntity<Void> addWorkshop(@RequestBody Workshop workshop){
        eventService.addWorkshop(workshop);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/parties")
    public ResponseEntity<Void> addParty(@RequestBody Party party){
        eventService.addParty(party);
        return ResponseEntity.ok().build();
    }

    @PatchMapping("/workshops")
    public ResponseEntity<Void> updateWorkshop(@RequestBody Workshop workshop){
        eventService.updateWorkshop(workshop);
        return ResponseEntity.ok().build();
    }

    @PatchMapping("/parties")
    public ResponseEntity<Void> updateParty(@RequestBody Party party){
        eventService.updateParty(party);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{workshopId}")
    public ResponseEntity<Void> deleteWorkshop(@PathVariable Long workshopId){
        eventService.deleteWorkshop(workshopId);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{partyId}")
    public ResponseEntity<Void> deleteParty(@PathVariable Long partyId){
        eventService.deleteParty(partyId);
        return ResponseEntity.ok().build();
    }

}
