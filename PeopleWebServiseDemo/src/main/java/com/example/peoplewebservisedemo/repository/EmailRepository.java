package com.example.peoplewebservisedemo.repository;

import com.example.peoplewebservisedemo.model.entity.Email;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmailRepository extends JpaRepository<Email, Long> {
}
