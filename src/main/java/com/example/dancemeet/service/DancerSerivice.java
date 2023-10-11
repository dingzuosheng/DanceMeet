package com.example.dancemeet.service;


import com.example.dancemeet.dto.DancerDto;
import com.example.dancemeet.exception.*;
import com.example.dancemeet.model.Dancer;
import com.example.dancemeet.model.Event;
import com.example.dancemeet.repository.DancerRepository;
import com.example.dancemeet.repository.EventRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class DancerSerivice {
    private final DancerRepository dancerRepository;
    private final EventRepository eventRepository;
    private final ModelMapper modelMapper = new ModelMapper();

    @Autowired
    public DancerSerivice(DancerRepository dancerRepository,
                          EventRepository eventRepository){
        this.dancerRepository = dancerRepository;
        this.eventRepository = eventRepository;
    }

    public Dancer register(DancerDto dancerDto){
        Dancer dancer = modelMapper.map(dancerDto, Dancer.class);
        if(!checkIfDancerExist(dancer.getEmail())) {
            dancerRepository.save(dancer);
            return dancer;
        }else{
            throw new DancerAlreadyExistsException();
        }
    }

    private boolean checkIfDancerExist(String email){
        Optional<Dancer> dancer = dancerRepository.findByEmail(email);
        return dancer.isPresent();
    }

    public Dancer login(String email, String password){
        Optional<Dancer> optionalDancer = dancerRepository.findByEmail(email);
        if(optionalDancer.isPresent()){
            Dancer dancer = optionalDancer.get();
            if(dancer.getPassword().equals(password)){
                return dancer;
            }else{
                throw new PasswordNotCorrectException();
            }
        }
        throw new DancerNotFoundException();
    }

    public boolean checkIfDancerHasEnoughToPay(Dancer dancer, double price){
        return dancer.getDeposit() >= price;
    }

    public void payTicket(Dancer dancer, Event event){
        if(checkIfDancerHasEnoughToPay(dancer,event.getPrice())){
            dancer.setDeposit(event.getPrice());
            event.receivePayment();
            dancer.setEvent(event);
            dancerRepository.save(dancer);
            List<Dancer> dancers = event.getMembers();
            dancers.add(dancer);
            event.setMembers(dancers);
            eventRepository.save(event);
        }else{
            throw new DepositNotEnoughException();
        }
    }

    public void joinEvent(Long dancerId, Long eventId){
        Optional<Dancer> optionalDancer = dancerRepository.findById(dancerId);
        Dancer dancer = null;
        if(optionalDancer.isPresent()){
            dancer = optionalDancer.get();
        }
        Optional<Event> optionalEvent = eventRepository.findById(eventId);
        Event event = null;
        if(optionalEvent.isPresent()){
            event = optionalEvent.get();
        }
        if(dancer.getEvent()==null){
            this.payTicket(dancer,event);
        }else{
            throw new NotAvailableException();
        }
    }

    public List<Dancer> getAllDancers(){
        return StreamSupport.stream(dancerRepository.findAll().spliterator(),false)
                .toList();
    }
}
