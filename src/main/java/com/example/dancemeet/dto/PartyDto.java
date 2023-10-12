package com.example.dancemeet.dto;


import com.example.dancemeet.model.Address;
import com.example.dancemeet.model.DanceType;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;
import java.util.List;

@AllArgsConstructor
@Data
public class PartyDto {
    private Date time;
    private double price;
    private Address address;
    private List<DanceType> musicTypes;
}
