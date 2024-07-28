package com.example.dev.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.dev.service.PointsService;

@RestController
@RequestMapping("/api/points")
public class PointsController {

	@Autowired
	private PointsService rewardService;

	@GetMapping("/{customerId}")
	public ResponseEntity<Map<String, Integer>> getRewards(@PathVariable Long customerId) {
		Map<String, Integer> rewards = rewardService.getCustomerRewards(customerId);
		return new ResponseEntity<>(rewards, HttpStatus.OK);
	}
}
