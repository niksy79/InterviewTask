package com.example.peoplewebservisedemo.controller;

import com.example.peoplewebservisedemo.dto.PeopleRequestDTO;
import com.example.peoplewebservisedemo.model.entity.People;
import com.example.peoplewebservisedemo.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
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

    @PutMapping("/people/edit/{id}")
    public ResponseEntity editDetails(@RequestBody PeopleRequestDTO requestDTO, @PathVariable long id){

        //TODO validations for empty fields

        personService.editPersonDetails(requestDTO, id);
        return ResponseEntity.status(HttpStatus.OK)
                .body("you are updated data successfully");
    }

    @GetMapping("/{id}")
    public People getById(@PathVariable long id){
        return personService.getById(id);
    }


    @DeleteMapping("/people/delete/{id}")
    public void delete(@PathVariable long id){

        personService.deletePersonById(id);

    }


}
