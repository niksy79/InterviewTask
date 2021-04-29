package com.example.peoplewebservisedemo.model.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@NoArgsConstructor
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

    @OneToOne(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "t_people_id", referencedColumnName = "id")
    @NotNull
    @JsonBackReference
    private People people;

    public Address(String addrInfo, String addrType, People people) {
        this.addrInfo = addrInfo;
        this.addrType = addrType;
        this.people = people;
    }
}
