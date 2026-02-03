package com.kodewala.payment.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kodewala.payment.entity.Payment;
import com.kodewala.payment.service.PaymentService;

@RestController
@RequestMapping("payment")
public class PaymentController {
    
	@Autowired
	PaymentService paymentService;
	
	@PostMapping("pay")
	public Payment makePayment(@RequestBody Payment payment)
	{
		return paymentService.doPayent(payment);
	}
	
	@GetMapping("order/{orderId}")
	public Payment getPayment(@PathVariable  Long orderId)
	{
		return paymentService.getPaymentByOrderId(orderId);
	}
}
