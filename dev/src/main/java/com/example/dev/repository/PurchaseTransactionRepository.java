package com.example.dev.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.dev.model.PointsTransaction;

public interface PurchaseTransactionRepository extends JpaRepository<PointsTransaction, Long> {

	List<PointsTransaction> findByCustomerId(Long customerId);

}
