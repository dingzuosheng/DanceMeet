package com.example.dancemeet.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Entity
@Table(name = "dance_skill")
public class DanceSkill {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String name;
    private Level level;
}
