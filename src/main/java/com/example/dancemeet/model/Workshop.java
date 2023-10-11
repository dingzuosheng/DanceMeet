package com.example.dancemeet.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Workshop extends Event{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long eventId;
    @OneToOne
    private Dancer trainer_m;

    @OneToOne
    private Dancer trainer_w;

    @Enumerated(EnumType.ORDINAL)
    @Column(name = "dance_type")
    private DancerType dancerType;

    @Enumerated(EnumType.ORDINAL)
    @Column(name = "level")
    private Level level;

}
