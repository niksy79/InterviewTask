package com.example.peoplewebservisedemo.dto;

import com.example.peoplewebservisedemo.model.entity.Email;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class EmailRequestDTO {

    private String email;
    private String emailType;
    private long peopleId;

    public EmailRequestDTO(Email email) {
        this.email = email.getEmail();
        this.emailType = email.getEmailType();
        this.peopleId = email.getPeople().getId();
    }
}
