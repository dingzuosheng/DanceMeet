package com.example.dancemeet.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Address {
    private Long addressId;

    private String city;

    private String street;

    private String zipCode;
}