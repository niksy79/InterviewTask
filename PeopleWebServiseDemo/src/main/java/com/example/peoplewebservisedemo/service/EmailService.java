package com.example.peoplewebservisedemo.service;

import com.example.peoplewebservisedemo.model.entity.Email;
import com.example.peoplewebservisedemo.repository.EmailRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class EmailService {

    @Autowired
    EmailRepository emailRepository;

   /* public Email saveEmail(Email emailRequest){
        Email email = new Email();
        email.setEmail(emailRequest.getEmail());
        email.s
    }*/
}
