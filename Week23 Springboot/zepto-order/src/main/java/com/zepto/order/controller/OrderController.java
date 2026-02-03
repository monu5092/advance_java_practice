package com.zepto.order.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.zepto.order.request.OrderRequest;
import com.zepto.order.response.OrderResponse;

@RestController
public class OrderController {
  
	
	@PostMapping("processOrder")
	public ResponseEntity processOrder(@RequestBody OrderRequest orderRequest)
	{
		OrderResponse orderResponse = new OrderResponse();
		orderResponse.setStatus("Process");
		orderResponse.setMessage("Order of the "+orderRequest.getItemName()+" are in process.");
		
		return ResponseEntity.ok(orderResponse);
	}
}
