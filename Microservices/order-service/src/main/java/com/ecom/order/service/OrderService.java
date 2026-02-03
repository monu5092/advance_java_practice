package com.ecom.order.service;

import org.springframework.stereotype.Service;

import com.ecom.order.entity.Order;
import com.ecom.order.entity.OrderItem;
import com.ecom.order.exception.OrderNotFoundException;
import com.ecom.order.repository.OrderRepository;
import com.ecom.order.request.OrderItemRequest;
import com.ecom.order.request.OrderRequest;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class OrderService {

    private final OrderRepository orderRepository;
    private final OrderProducer orderProducer;

    public OrderService(OrderRepository orderRepository,
                        OrderProducer orderProducer) {
        this.orderRepository = orderRepository;
        this.orderProducer = orderProducer;
    }

    public Order createOrder(OrderRequest request) {

        Order order = new Order();
        order.setUserId(request.getUserId());
        order.setStatus("CREATED");

        for (OrderItemRequest itemReq : request.getItems()) {
            OrderItem item = new OrderItem();
            item.setProductId(itemReq.getProductId());
            item.setQuantity(itemReq.getQuantity());
            item.setOrder(order);
            order.getItems().add(item);
        }

        Order savedOrder = orderRepository.save(order);

 
        orderProducer.sendOrderCreatedEvent(savedOrder.getId());

        return savedOrder;
    }

    public Order getOrder(Long id) {
        return orderRepository.findById(id)
                .orElseThrow(() ->
                        new OrderNotFoundException("Order not found with id " + id));
    }
}

