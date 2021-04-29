package com.example.peoplewebservisedemo.dto;
import com.example.peoplewebservisedemo.model.entity.People;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Getter
@Setter
@NoArgsConstructor
public class PeopleRequestDTO {




    @NotEmpty
    @Pattern(regexp = "^[a-zA-Zа-яА-Я- ]+", message = "please, enter a correct name")
    private String fullName;

    @Email(regexp = "[a-z0-9._%+-]{3,30}+@[a-z0-9.-]+\\.[a-z]{2,4}")
    private String email;

    @Size(min = 3, max = 6, message = "email type must be between 3 and 6 characters")
    @NotEmpty
    private String emailType;

    @Size(min = 3, max = 6, message = "address type must be between 3 and 6 characters")
    @NotEmpty
    private String addrType;

    @Size(min = 5,max = 300, message = "address must be between 5 and 300 characters")
    @NotEmpty
    private String address;

    @Size(min = 10, max = 10, message = "the pin must contains exactly 10 digits")
    @Pattern(regexp = "^[0-9]+$", message = "the pin must contains only digits")
    @NotEmpty
    private String pin;





    public PeopleRequestDTO(People people) {
        this.fullName = people.getFullName();
        this.pin = people.getPin();
        this.email = people.getEmail().getEmail();
        this.emailType = people.getEmail().getEmailType();
        this.address = people.getAddress().getAddrInfo();
        this.addrType = people.getAddress().getAddrType();
    }
}
