package com.example.peoplewebservisedemo.dto;

import com.example.peoplewebservisedemo.model.entity.People;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class PeopleResponseDTO {

    private String fullName;
    private String email;
    private String emailType;
    private String addrType;
    private String address;

    public PeopleResponseDTO(People people) {
        this.fullName = people.getFullName();
        this.email = people.getEmail().getEmail();
        this.emailType = people.getEmail().getEmailType();
        this.address = people.getAddress().getAddrInfo();
        this.addrType = people.getAddress().getAddrType();
    }
}
