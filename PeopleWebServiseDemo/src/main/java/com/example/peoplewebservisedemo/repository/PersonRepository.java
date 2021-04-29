package com.example.peoplewebservisedemo.repository;

import com.example.peoplewebservisedemo.model.entity.People;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends JpaRepository<People, Long> {


}
