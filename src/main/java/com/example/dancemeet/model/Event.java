package com.example.dancemeet.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "event")
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long eventId;

    @Column(name = "time")
    private Date time;

    @Column(name = "price")
    private double price;

    @OneToOne
    private Address address;

    @Column(name = "deposit")
    private double deposit;

    @OneToMany
    private List<Dancer> members;

    public void receivePayment(){
        this.deposit += this.price;
    }
}
