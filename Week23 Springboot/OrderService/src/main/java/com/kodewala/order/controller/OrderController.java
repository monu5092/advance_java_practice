package com.kodewala.order.controller;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kodewala.order.entity.Order;
import com.kodewala.order.request.OrderRequest;
import com.kodewala.order.service.OrderService;

@RestController
@RequestMapping("order")
public class OrderController {
	
	private static final Logger log = LoggerFactory.getLogger(OrderController.class);

	@Autowired
	OrderService orderService;
	
	@PostMapping("create")
   public ResponseEntity<Order> placeOrder(@RequestBody OrderRequest orderRequest)
   {
		log.info("Placing  order: {}",orderRequest);
		
	   Order order = orderService.placeOrder(orderRequest.getProductId(),orderRequest.getItemName(),
			          orderRequest.getOrderStatus(),orderRequest.getQuantity());
	   
	   return ResponseEntity.ok(order);
	   
   }
   
   
	@GetMapping("{id}")
	public ResponseEntity<Order> getorder(@PathVariable Long id)
	{
		return ResponseEntity.ok(orderService.getOrder(id));
	}
   
	
	
}
