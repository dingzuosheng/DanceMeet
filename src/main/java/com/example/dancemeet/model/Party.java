package com.example.dancemeet.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Party{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long partyId;

    @Column(name = "time", unique = true)
    private Date time;

    @Column(name = "price")
    private double price;

    @OneToOne
    private Address address;

    @Column(name = "deposit")
    private double deposit;

    @OneToMany
    private List<Dancer> members;

    @Enumerated(EnumType.ORDINAL)
    private List<DanceType> musicTypes;

    public void receivePayment(){
        this.deposit += this.price;
    }
}
