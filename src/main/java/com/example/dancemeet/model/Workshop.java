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
public class Workshop{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long workshopId;

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

    @OneToOne
    private Dancer coach1;

    @OneToOne
    private Dancer coach2;

    @Enumerated(EnumType.ORDINAL)
    @Column(name = "dance_type")
    private DanceType danceType;

    @Enumerated(EnumType.ORDINAL)
    @Column(name = "level")
    private Level level;

    public void receivePayment(){
        this.deposit += this.price;
    }

}
