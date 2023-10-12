package com.example.dancemeet.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Entity
@Table(name = "dancer")
public class Dancer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long dancerId;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Enumerated(EnumType.ORDINAL)
    @Column(name = "gender")
    private Gender gender;
    @Column(name = "email")
    private String email;
    @Column(name = "password")
    private String password;
    @OneToMany
    private List<DanceSkill> skills;
    @OneToMany
    private List<DanceSkill> coachskills;
    @ManyToOne
    private Workshop workshop;
    @ManyToOne
    private Party party;
    @Column
    private double deposit;

    public void payTicket(double price){
        this.deposit -= price;
    }

}
