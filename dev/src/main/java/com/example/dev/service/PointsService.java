package com.example.dev.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dev.model.PointsTransaction;
import com.example.dev.repository.PurchaseTransactionRepository;

@Service
public class PointsService {

	@Autowired
	private PurchaseTransactionRepository transactionRepository;

	public int calculatePoints(double amount) {
		int points = 0;
		if (amount > 100) {
			points += (amount - 100) * 2; //receives 2 points for every dollar spent over $100 in each transaction.
			amount = 100;
		}
		if (amount > 50) {
			points += (amount - 50); //1 point for every dollar spent between $50 and $100 in each transaction.
		}
		return points;
	}

	public Map<String, Integer> getCustomerRewards(Long customerId) {
		List<PointsTransaction> transactions = transactionRepository.findByCustomerId(customerId);
		Map<String, Integer> monthlyRewards = new HashMap<>();

		for (PointsTransaction transaction : transactions) {
			String month = transaction.getDate().getMonth().toString(); //get the data on Monthly basis
			int points = calculatePoints(transaction.getAmount()); //get the points based on Amount
			monthlyRewards.put(month, monthlyRewards.getOrDefault(month, 0) + points);
		}

		return monthlyRewards;
	}
}
