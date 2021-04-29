package com.example.peoplewebservisedemo.model.entity;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "t_people")
public class People {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotNull
    @Column(name = "full_name", length = 90)
    private String fullName;

    @Column(name = "pin", length = 10)
    @NotNull
    private String pin;

    @OneToOne(mappedBy = "people", cascade = CascadeType.ALL)
    private Address address;

    @OneToOne(mappedBy = "people", cascade = CascadeType.ALL)
    private Email email;


    public People(String fullName, String pin, Address address, Email email) {
        this.fullName = fullName;
        this.pin = pin;
        this.address = address;
        this.email = email;
    }
}
