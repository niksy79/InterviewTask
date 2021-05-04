package com.example.peoplewebservisedemo.controller;
import com.example.peoplewebservisedemo.dto.PeopleRequestDTO;
import com.example.peoplewebservisedemo.model.entity.People;
import com.example.peoplewebservisedemo.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RestController
@RequestMapping("/people")
public class PeopleController extends AbstractController {


    private final PersonService personService;

    @Autowired
    public PeopleController(PersonService personService) {
        this.personService = personService;
    }

    @PostMapping("/insert")
    public ResponseEntity insertPerson(@Valid @RequestBody PeopleRequestDTO requestDTO) {

        personService.insertPerson(requestDTO);

        return ResponseEntity.status(HttpStatus.OK)
                .body("you are insert data successfully");
    }

    @GetMapping("/get/{name}")
    public List<People> getPeopleByName(@PathVariable String name) {

        return personService.getByName(name);
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity editDetails(@Valid @RequestBody PeopleRequestDTO requestDTO, @PathVariable long id) {

        //TODO validations for empty fields

        personService.editPersonDetails(requestDTO, id);
        return ResponseEntity.status(HttpStatus.OK)
                .body("you are updated data successfully");
    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity delete(@PathVariable Long id) {

        personService.deletePersonById(id);

        return ResponseEntity.status(HttpStatus.OK)
                .body("Person with id " + id + " was deleted successfully");
    }

}
