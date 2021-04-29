package com.example.peoplewebservisedemo.model.entity;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Data
@Entity
@Table(name = "t_addresses")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;


    @Column(name = "addr_info", length = 300)
    private String addrInfo;

    @NotNull
    @Column(name = "addr_type", length = 6)
    private String addrType;

    @OneToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "t_people_id", referencedColumnName = "id")
    @NotNull
    private People people;

    public Address(String addrInfo, String addrType, People people) {
        this.addrInfo = addrInfo;
        this.addrType = addrType;
        this.people = people;
    }
}
