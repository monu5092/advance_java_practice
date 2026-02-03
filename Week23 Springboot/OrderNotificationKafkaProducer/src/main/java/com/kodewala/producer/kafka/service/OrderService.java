package com.kodewala.producer.kafka.service;

import java.util.concurrent.ExecutionException;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.kodewala.producer.kafka.config.KafkaConfig;
import com.kodewala.producer.kafka.entity.Order;
import com.kodewala.producer.kafka.repository.OrderRepository;
import com.kodewala.producer.kafka.request.OrderRequest;
import com.kodewala.producer.kafka.response.OrderResponse;

import tools.jackson.databind.ObjectMapper;

@Service
public class OrderService {

    private final KafkaConfig kafkaConfig;

	@Autowired
	OrderRepository orderRepository;
	
	@Autowired
	private KafkaProducer<String, String> producer;
	
	@Autowired
	private ObjectMapper mapper;


    OrderService(KafkaConfig kafkaConfig) {
        this.kafkaConfig = kafkaConfig;
    }
	
	
	public void createOrder(OrderRequest  orderRequest) throws InterruptedException,ExecutionException
	{
		Order order = new Order();
		
		order.setCustomerId(orderRequest.getCustomerId());
		order.setProductList(orderRequest.getProducts());
		order.setPrices(orderRequest.getPrices());
		order.setTotalPrice(orderRequest.getTotalPrice());
		order.setPaymentStatus(orderRequest.getPymentStatus());
		
		Order perSistedOrder = orderRepository.save(order);
		
		
		Long orderId = perSistedOrder.getOrderId();
		String customerId = perSistedOrder.getCustomerId();
		String paymentStatus = perSistedOrder.getPaymentStatus();
		
		OrderResponse response = new OrderResponse();
		response.setOrderId(orderId);
		response.setCustomerId(customerId);
		response.setPaymentStatus(paymentStatus);
		
		// Convert Response Object to JSON String
		String jsonValue = mapper.writeValueAsString(response);
		
		//Fix: Convert Long orderId to String to match Producer generics <String, String>
		String kafkaKey = String.valueOf(perSistedOrder.getOrderId());
		
		ProducerRecord<String,String>  reocrd = new ProducerRecord<String, String>("order-event",kafkaKey, jsonValue);
		
		producer.send(reocrd);
		
		System.out.println("message sent to kafka");
		
		
		
		
		
	}
}
