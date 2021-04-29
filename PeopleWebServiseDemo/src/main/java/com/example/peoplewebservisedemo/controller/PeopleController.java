package com.example.peoplewebservisedemo.controller;

import com.example.peoplewebservisedemo.dto.PeopleRequestDTO;
import com.example.peoplewebservisedemo.dto.PeopleResponseDTO;
import com.example.peoplewebservisedemo.model.entity.People;
import com.example.peoplewebservisedemo.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class PeopleController extends AbstractController {

    @Autowired
    PersonService personService;

    /*@Autowired
    public PeopleController(PersonService personService) {
        this.personService = personService;
    }*/

    @PostMapping("/people/insert")
    public ResponseEntity insertPerson(@Valid @RequestBody PeopleRequestDTO requestDTO) {
        personService.insertPerson(requestDTO);

        return ResponseEntity.status(HttpStatus.OK)
                .body("you are insert data successfully");
    }

    @GetMapping("people/get/{name}")
    public List<People> getPeopleByName(@PathVariable String name) {

        return personService.getByName(name);
    }


}
