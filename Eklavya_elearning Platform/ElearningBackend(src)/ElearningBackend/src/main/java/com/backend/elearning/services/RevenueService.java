package com.backend.elearning.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import com.backend.elearning.repositories.TotalRevenue;



@Service
public class RevenueService {

    @Autowired
    TotalRevenue orderRepository;

    public Double getTotalPriceByUserId(Long userId) {
        return orderRepository.getTotalPriceByUserId(userId);
    }
}