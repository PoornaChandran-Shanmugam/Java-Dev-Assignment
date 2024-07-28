package com.example.dev.service;

import java.util.concurrent.CompletableFuture;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class AsyncPointService {

    @Async
    public CompletableFuture<String> fetchData() {
        // Simulate a long-running task
        try {
            Thread.sleep(3000); // Simulate a 3-second delay
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return CompletableFuture.completedFuture("Data Fetched from Async Process...");
    }}
