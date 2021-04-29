package com.example.peoplewebservisedemo.repository;

import com.example.peoplewebservisedemo.model.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Long> {
}
