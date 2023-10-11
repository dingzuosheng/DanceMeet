package com.example.dancemeet.dto;

import com.example.dancemeet.model.Gender;
import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class DancerDto {

    private String firstName;
    private String lastName;
    private Gender gender;
    private String email;
    private String password;
}
