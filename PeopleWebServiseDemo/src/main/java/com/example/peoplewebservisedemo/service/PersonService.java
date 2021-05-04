package com.example.peoplewebservisedemo.service;
import com.example.peoplewebservisedemo.dto.PeopleRequestDTO;
import com.example.peoplewebservisedemo.dto.PeopleResponseDTO;
import com.example.peoplewebservisedemo.exception.BadRequestException;
import com.example.peoplewebservisedemo.exception.NotFoundException;
import com.example.peoplewebservisedemo.model.entity.Address;
import com.example.peoplewebservisedemo.model.entity.Email;
import com.example.peoplewebservisedemo.model.entity.People;
import com.example.peoplewebservisedemo.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;



@Service
public class PersonService implements IPersonService {

    @Autowired
    PersonRepository personRepository;


    @Override
    public PeopleResponseDTO insertPerson(PeopleRequestDTO requestDTO) {

        if (personRepository.existsByPin(requestDTO.getPin())) {
            throw new BadRequestException("Person with pin " + requestDTO.getPin() + " already exist");
        }
        People people = new People();
        people.setFullName(requestDTO.getFullName());
        people.setPin(requestDTO.getPin());
        people.setEmail(new Email(requestDTO.getEmail(), requestDTO.getEmailType(), people));
        people.setAddress(new Address(requestDTO.getAddress(), requestDTO.getAddrType(), people));

        personRepository.save(people);

        return new PeopleResponseDTO(people);
    }

    @Override
    public List<PeopleResponseDTO> getByName(String name) {
        List<People> result = personRepository.findAllByFullNameContaining(name);
        if (result.isEmpty()) {
            throw new NotFoundException("People by name " + name + " was not found");
        }
        List<PeopleResponseDTO> personDetails = new ArrayList<>();
        for (People p : result){
            personDetails.add(new PeopleResponseDTO(p));
        }

        return personDetails;
    }

    @Override
    public PeopleResponseDTO editPersonDetails(PeopleRequestDTO requestDTO, Long id) {

        People result = personRepository.findById(id).orElseThrow(() ->
                new NotFoundException("Person with id " + id + " was not found"));
        
        Address address = result.getAddress();
        address.setAddrType(requestDTO.getAddrType());
        address.setAddrInfo(requestDTO.getAddress());

        Email email = result.getEmail();
        email.setEmail(requestDTO.getEmail());
        email.setEmailType(requestDTO.getEmailType());

        result.setFullName(requestDTO.getFullName());
        result.setPin(requestDTO.getPin());
        result.setAddress(address);
        result.setEmail(email);

        result = personRepository.save(result);

        return new PeopleResponseDTO(result);
    }

    @Override
    public void deletePersonById(long id) {
        People result = personRepository.findById(id).orElseThrow(()
                -> new NotFoundException("Person by id " + id + " was not found"));
        personRepository.delete(result);
    }

}
