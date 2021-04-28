package com.example.peoplewebservisedemo.model.entity;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Data
@Entity
@Table(name = "t_people")
public class People {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotNull
    @Pattern(regexp = "[^a-zA-Zа-яА-Я/s-]")
    @Column(name = "full_name", length = 90)
    private String fullName;

    @Column(name = "pin", length = 10)
    @Size(min = 10, max = 10, message = "the pin must contains exactly 10 digits")
    @Pattern(regexp = "^[0-9]", message = "the pin must contains only digits")
    @NotNull
    private String pin;

    @OneToOne(mappedBy = "people")
    private Address address;

    @OneToOne(mappedBy = "people")
    private Email email;

}
