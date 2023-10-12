package com.example.dancemeet.service;


import com.example.dancemeet.exception.EventAlreadyExistException;
import com.example.dancemeet.model.Dancer;
import com.example.dancemeet.model.Party;
import com.example.dancemeet.model.Workshop;
import com.example.dancemeet.repository.DancerRepository;
import com.example.dancemeet.repository.PartyRepository;
import com.example.dancemeet.repository.WorkshopRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.StreamSupport;

@Slf4j
@Service
public class EventService {
    private final WorkshopRepository workshopRepository;
    private final PartyRepository partyRepository;
    private final DancerRepository dancerRepository;

    @Autowired
    public EventService(WorkshopRepository workshopRepository,
                        PartyRepository partyRepository,
                        DancerRepository dancerRepository){
        this.workshopRepository = workshopRepository;
        this.partyRepository = partyRepository;
        this.dancerRepository = dancerRepository;
    }

    public void addWorkshop(Workshop workshop){
        if(!checkIfWorkshopAlreadyExists(workshop)){
            if(checkIfCoachAlreadyExists(workshop.getCoach1())
                    && checkIfCoachAlreadyExists(workshop.getCoach2())) {
                workshopRepository.save(workshop);
            }
        }else {
            throw new EventAlreadyExistException();
        }
    }
    public void addParty(Party party){
        if(!checkIfPartyAlreadyExists(party)){
            partyRepository.save(party);
        }else {
            throw new EventAlreadyExistException();
        }
    }

    private boolean checkIfPartyAlreadyExists(Party party){
        Optional<Party> optionalParty = partyRepository.findById(party.getPartyId());
        return optionalParty.isPresent();
    }

    public boolean checkIfWorkshopAlreadyExists(Workshop workshop){
        Optional<Workshop> optionalEvent = workshopRepository.findById(workshop.getWorkshopId());
        return optionalEvent.isPresent();
    }

    public void deleteWorkshop(Long workshopId){
        workshopRepository.deleteById(workshopId);
    }

    public void deleteParty(Long partyId){
        partyRepository.deleteById(partyId);
    }

    private boolean checkIfCoachAlreadyExists(Dancer dancer){
        Optional<Dancer> optionalDancer = dancerRepository.findById(dancer.getDancerId());
        return optionalDancer.isPresent();
    }

    public List<Workshop> getAllWorkshops(){
        return StreamSupport.stream(workshopRepository.findAll().spliterator(), false)
                            .toList();
    }

    public List<Party> getAllParties(){
        return StreamSupport.stream(partyRepository.findAll().spliterator(), false)
                            .toList();
    }

    public Workshop getWorkshop(Long workshopId){
        Optional<Workshop> optionalWorkshop = workshopRepository.findById(workshopId);
        return optionalWorkshop.orElse(null);
    }

    public Party getParty(Long partyId){
        Optional<Party> optionalParty = partyRepository.findById(partyId);
        return optionalParty.orElse(null);
    }


}
