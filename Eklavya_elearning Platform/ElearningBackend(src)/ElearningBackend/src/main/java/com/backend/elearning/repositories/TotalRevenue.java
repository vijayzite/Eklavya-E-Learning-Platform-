package com.backend.elearning.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.backend.elearning.models.Order;


@Repository

public interface TotalRevenue extends JpaRepository<Order, Integer> {

    @Query("SELECT SUM(o.totalAmt) FROM Order o WHERE o.course.user.userId = :userId")
    Double getTotalPriceByUserId(@Param("userId") Long userId);
}