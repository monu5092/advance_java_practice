package com.kodewala.order.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.kodewala.order.config.ProductClient;
import com.kodewala.order.dto.Product;
import com.kodewala.order.entity.Order;
import com.kodewala.order.kafka.KafkaProducerService;
import com.kodewala.order.repository.OrderRepository;

@Service
public class OrderService {


	@Autowired
	OrderRepository orderRepository;
	
	@Autowired
	ProductClient productClient;
	
	@Autowired
	KafkaProducerService kafkaProducerService;

    
	
	public Order placeOrder(Long productId,String itemName,String orderStatus,int quantity)
	{
		Product product = productClient.getProduct(productId);
		
		Order order = new Order();
		
		order.setProductId(productId);
		order.setQuantity(quantity);
		order.setOrderStatus(orderStatus);
		order.setPrice(quantity*product.getPrice());
		order.setItemName(itemName);
		
		orderRepository.save(order);
		
		try {
			String orderJson = new ObjectMapper().writeValueAsString(order);
			kafkaProducerService.sendMessage(orderJson);
		} catch(JsonProcessingException e)
		{
			e.printStackTrace();
		}
		
		return order;
	}
	
	public Order getOrder(Long id)
	{
		return orderRepository.findById(id).orElseThrow(()->new RuntimeException("Order not found by the id "+ id));
	}
	
}
