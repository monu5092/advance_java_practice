package com.ecom.payment.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecom.payment.entity.Payment;
import com.ecom.payment.request.PaymentRequest;
import com.ecom.payment.service.PaymentService;

@RestController
@RequestMapping("/payments")
public class PaymentController {
      
	  private final PaymentService paymentService;
	  
	  public PaymentController(PaymentService paymentService)
	  {
		  this.paymentService = paymentService;
	  }
	  
	  
	  @PostMapping("create")
	  public ResponseEntity<Payment> makePayment(@RequestBody PaymentRequest request)
	  {
		  return new ResponseEntity<>(paymentService.processPayment(request),HttpStatus.CREATED);
	  }
}
