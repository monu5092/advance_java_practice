package com.update.status.order.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.update.status.order.dto.OrderStatusRequest;
import com.update.status.order.entity.Order;
import com.update.status.order.service.OrderStatusService;

@RestController
@RequestMapping("order")
public class OrderStatusController {

	private final OrderStatusService orderStatusService;
	
	public OrderStatusController(OrderStatusService orderStatusService)
	{
		this.orderStatusService = orderStatusService;
	}
	
	
	@PutMapping("{id}/status")
	public ResponseEntity<Map<String, Object>> updateOrderStatus(@PathVariable int id,@RequestBody OrderStatusRequest status)
	{
		  Order updateOrder = orderStatusService.updateOrderStatus(id,status.getStatus());
		  
		  Map<String, Object> response = new HashMap<>();
		  response.put("message", "Order status updated successfully");
		    response.put("status", updateOrder.getStatus());
		    response.put("order", updateOrder);

		    return ResponseEntity.ok(response);
		  
	}
}
