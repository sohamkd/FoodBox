package com.FoodBox.Repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.FoodBox.Model.OrderData;

public interface OrderDataRepository extends JpaRepository<OrderData, Long> {

}
