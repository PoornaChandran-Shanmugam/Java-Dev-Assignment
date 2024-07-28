package com.example.dev.controller;

import java.util.concurrent.CompletableFuture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.dev.service.AsyncPointService;


@RestController
@RequestMapping("/api/async-point")
public class AsyncPointsController {

    @Autowired
    private AsyncPointService asyncRewardService;

    @GetMapping("/fetch")
    public CompletableFuture<ResponseEntity<String>> fetchAsyncData() {
        return asyncRewardService.fetchData()
                .thenApply(data -> ResponseEntity.ok(data));
    }}
