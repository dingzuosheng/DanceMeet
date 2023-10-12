package com.example.dancemeet.dto;


import com.example.dancemeet.model.Address;
import com.example.dancemeet.model.Dancer;
import com.example.dancemeet.model.DanceType;
import com.example.dancemeet.model.Level;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@AllArgsConstructor
@Data
public class WorkshopDto {
    private Date time;
    private double price;
    private Address address;
    private Dancer coach1;
    private Dancer coach2;
    private DanceType danceType;
    private Level level;
}
