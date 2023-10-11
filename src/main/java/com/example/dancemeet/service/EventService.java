package com.example.dancemeet.service;


import com.example.dancemeet.exception.EventAlreadyExistException;
import com.example.dancemeet.exception.EventNotFoundException;
import com.example.dancemeet.model.Party;
import com.example.dancemeet.model.Workshop;
import com.example.dancemeet.repository.AddressRepository;
import com.example.dancemeet.repository.PartyRepository;
import com.example.dancemeet.repository.WorkshopRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Slf4j
@Service
public class EventService {
    private final WorkshopRepository workshopRepository;
    private final PartyRepository partyRepository;
    private final AddressRepository addressRepository;

    @Autowired
    public EventService(WorkshopRepository workshopRepository,
                        PartyRepository partyRepository,
                        AddressRepository addressRepository){
        this.workshopRepository = workshopRepository;
        this.partyRepository = partyRepository;
        this.addressRepository = addressRepository;
    }

    public void addWorkshop(Workshop workshop){
        if(!checkIfWorkshopAlreadyExists(workshop)){
            addressRepository.save(workshop.getAddress());
            workshopRepository.save(workshop);
        }else {
            throw new EventAlreadyExistException();
        }
    }
    public void addParty(Party party){
        if(!checkIfPartyAlreadyExists(party)){
            addressRepository.save(party.getAddress());
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

    public void updateWorkshop(Workshop workshop){
        if(checkIfWorkshopAlreadyExists(workshop)){
            throw new EventNotFoundException();
        }
        addressRepository.save(workshop.getAddress());
        workshopRepository.save(workshop);
    }
    public void updateParty(Party party){
        if(checkIfPartyAlreadyExists(party)){
            throw new EventNotFoundException();
        }
        addressRepository.save(party.getAddress());
        partyRepository.save(party);
    }
}
