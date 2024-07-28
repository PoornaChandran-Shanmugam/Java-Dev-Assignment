package com.example.dev.controller;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.example.dev.model.CustomerData;
import com.example.dev.model.PointsTransaction;
import com.example.dev.repository.CustomerDetailRepository;

@Component
public class DataProcessor implements CommandLineRunner {

	@Autowired
	private CustomerDetailRepository customerRepository;

	@Override
	public void run(String... args) throws Exception {
		
		//Customer 1 Data Processing
		CustomerData customer1 = new CustomerData();
        customer1.setId(1L);
        customer1.setName("Dev");

        List<PointsTransaction> transactions1 = Arrays.asList(
                new PointsTransaction(LocalDate.of(2024, 5, 15), 120.0, customer1),
                new PointsTransaction(LocalDate.of(2024, 6, 22), 75.0, customer1)
        );

        customer1.setTransactions(transactions1);
        customerRepository.save(customer1);

		//Customer 2 Data Processing
        CustomerData customer2 = new CustomerData();
        customer2.setId(2L);
        customer2.setName("Suriya");

        List<PointsTransaction> transactions2 = Arrays.asList(
                new PointsTransaction(LocalDate.of(2024, 6, 25), 200.0, customer2),
                new PointsTransaction(LocalDate.of(2024, 7, 10), 80.0, customer2)
        );

        customer2.setTransactions(transactions2);
        customerRepository.save(customer2);
	}
}