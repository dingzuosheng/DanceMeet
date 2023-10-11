package com.example.dancemeet.service;


import com.example.dancemeet.dto.DancerDto;
import com.example.dancemeet.exception.*;
import com.example.dancemeet.model.Dancer;
import com.example.dancemeet.repository.DancerRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.StreamSupport;

@Service
public class DancerSerivice {
    private final DancerRepository dancerRepository;
    private final ModelMapper modelMapper = new ModelMapper();

    @Autowired
    public DancerSerivice(DancerRepository dancerRepository){
        this.dancerRepository = dancerRepository;
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

    public List<Dancer> getAllDancers(){
        return StreamSupport.stream(dancerRepository.findAll().spliterator(),false)
                .toList();
    }
}
