package com.update.status.order.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.update.status.order.entity.Order;
import com.update.status.order.repository.OrderRepository;

@Service
public class OrderStatusService {

    @Autowired
    private OrderRepository orderRepository;

    public Order updateOrderStatus(int id, String status) {

        Order order = orderRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Order not found with id : " + id)
                );

        String currStatus = order.getStatus();

        boolean isValid =
                ("PLACED".equalsIgnoreCase(currStatus) &&
                 "SHIPPED".equalsIgnoreCase(status)) ||

                ("SHIPPED".equalsIgnoreCase(currStatus) &&
                 "DELIVERED".equalsIgnoreCase(status));

        if (!isValid) {
            throw new RuntimeException(
                    "Invalid status transition from " + currStatus + " to " + status
            );
        }

        order.setStatus(status.toUpperCase());
        return orderRepository.save(order);
    }
}
