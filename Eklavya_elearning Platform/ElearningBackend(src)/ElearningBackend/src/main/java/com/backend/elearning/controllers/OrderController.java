package com.backend.elearning.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.backend.elearning.repositories.TotalRevenue;
import com.backend.elearning.services.RevenueService;
@CrossOrigin(origins = "http://localhost:3000")
@RestController

public class OrderController {

    @Autowired
    RevenueService orderService;

    @GetMapping("/getTotalPrice/{userId}")
    public ResponseEntity<Double> getTotalPriceByUserId(@PathVariable("userId") Long userId) {
        Double totalPrice = orderService.getTotalPriceByUserId(userId);
        if (totalPrice != null) {
            return ResponseEntity.ok(totalPrice);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}