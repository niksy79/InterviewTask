package com.example.peoplewebservisedemo.service;

import com.example.peoplewebservisedemo.dto.PeopleRequestDTO;
import com.example.peoplewebservisedemo.dto.PeopleResponseDTO;
import com.example.peoplewebservisedemo.exception.NotFoundException;
import com.example.peoplewebservisedemo.model.entity.Address;
import com.example.peoplewebservisedemo.model.entity.Email;
import com.example.peoplewebservisedemo.model.entity.People;
import com.example.peoplewebservisedemo.repository.PersonRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class PersonService {

    @Autowired
    PersonRepository personRepository;


    public PeopleResponseDTO insertPerson(PeopleRequestDTO requestDTO) {

        People people = new People();
        people.setFullName(requestDTO.getFullName());
        people.setPin(requestDTO.getPin());
        people.setEmail(new Email(requestDTO.getEmail(), requestDTO.getEmailType(), people));
        people.setAddress(new Address(requestDTO.getAddress(), requestDTO.getAddrType(), people));
        personRepository.save(people);

        return new PeopleResponseDTO(people);
    }

    public List<People> getByName(String name) {

        List<People> result = personRepository.findAllByFullNameContaining(name);
        if (result.isEmpty()){
            throw new NotFoundException("People by name " + name + " was not found" );
        }
        return result;
    }



}
