package com.example.dev.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.dev.model.CustomerData;

public interface CustomerDetailRepository extends JpaRepository<CustomerData, Long> {

}
