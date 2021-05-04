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
import java.util.List;
import java.util.Optional;


@Service
public class PersonService {

    @Autowired
    PersonRepository personRepository;

    public PeopleResponseDTO insertPerson(PeopleRequestDTO requestDTO) {

        if (personRepository.existsByPin(requestDTO.getPin())) {
            throw new BadRequestException("This person already exist");
        }

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
        if (result.isEmpty()) {
            throw new NotFoundException("People by name " + name + " was not found");
        }
        return result;
    }

    public People editPersonDetails(PeopleRequestDTO requestDTO, Long id) {

        Optional<People> people = personRepository.findById(id);
        if (people.isEmpty()) {
            throw new NotFoundException("Person by id " + id + " was not found");
        }
        People result = people.get();
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

        return result;
    }

    public void deletePersonById(long id) {
        Optional<People> people = personRepository.findById(id);
        if (people.isEmpty()) {
            throw new NotFoundException("Person by id " + id + " was not found");
        }
        personRepository.delete(people.get());
    }

}
