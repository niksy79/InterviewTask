package com.example.peoplewebservisedemo.service;

import com.example.peoplewebservisedemo.dto.PeopleRequestDTO;
import com.example.peoplewebservisedemo.dto.PeopleResponseDTO;
import com.example.peoplewebservisedemo.model.entity.People;

import java.util.List;

public interface IPersonService {

    PeopleResponseDTO insertPerson(PeopleRequestDTO requestDTO);

    List<PeopleResponseDTO> getByName(String name);

   PeopleResponseDTO editPersonDetails(PeopleRequestDTO requestDTO, Long id);

    void deletePersonById(long id);
}
