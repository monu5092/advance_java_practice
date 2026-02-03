package com.update.status.order.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.update.status.order.entity.Order;

public interface OrderRepository extends JpaRepository<Order, Integer> {

}
