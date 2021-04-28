package com.example.peoplewebservisedemo.model.entity;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@Entity
@Table(name = "t_mails")
public class Email {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "email", length = 40)
    @NotNull
    private String email;

    @Column(name = "email_type", length = 6)
    @NotNull
    private String emailType;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "t_people_id",  referencedColumnName = "id")
    @NotNull
    private People people;
}
