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
@RequestMapping("/people")
public class PeopleController extends AbstractController {


    private final PersonService personService;

    @Autowired
    public PeopleController(PersonService personService) {
        this.personService = personService;
    }

    @PostMapping("/insert")
    public ResponseEntity<PeopleResponseDTO> insertPerson(@Valid @RequestBody PeopleRequestDTO requestDTO) {
        PeopleResponseDTO result = personService.insertPerson(requestDTO);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    @GetMapping("/get/{name}")
    public List<People> getPeopleByName(@PathVariable String name) {

        return personService.getByName(name);
    }

    @PutMapping("/{id}/edit")
    public ResponseEntity<People> editDetails(@Valid @RequestBody PeopleRequestDTO requestDTO, @PathVariable long id) {
        People result = personService.editPersonDetails(requestDTO, id);

        return ResponseEntity.status(HttpStatus.OK).body(result);
    }


    @DeleteMapping("/{id}/delete")
    public ResponseEntity delete(@PathVariable Long id) {

        personService.deletePersonById(id);

        return ResponseEntity.status(HttpStatus.OK)
                .body("Person with id " + id + " was deleted successfully");
    }

}
