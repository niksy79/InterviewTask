package com.example.peoplewebservisedemo.service;

import com.example.peoplewebservisedemo.dto.PeopleRequestDTO;
import com.example.peoplewebservisedemo.dto.PeopleResponseDTO;
import com.example.peoplewebservisedemo.model.entity.Address;
import com.example.peoplewebservisedemo.model.entity.Email;
import com.example.peoplewebservisedemo.model.entity.People;
import com.example.peoplewebservisedemo.repository.EmailRepository;
import com.example.peoplewebservisedemo.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;

@Service
public class PersonService {

    private final PersonRepository personRepository;


    @Autowired
    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }



    public PeopleResponseDTO insertPerson(PeopleRequestDTO requestDTO) {

        People people = new People();
        people.setFullName(requestDTO.getFullName());
        people.setPin(requestDTO.getPin());
        people.setEmail(new Email(requestDTO.getEmail(), requestDTO.getEmailType(), people));
        people.setAddress(new Address(requestDTO.getAddress(), requestDTO.getAddrType(), people));
        personRepository.save(people);

        return new PeopleResponseDTO(people);
    }

}
