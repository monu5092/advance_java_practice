package com.zepto.payment.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zepto.payment.request.PaymentRequest;
import com.zepto.payment.service.PaymentService;

@Controller
public class PaymentController {

	@Autowired
	PaymentService paymentService;
	
	@RequestMapping("cardPayment")
	@ResponseBody
	public ResponseEntity confirmPayment(@RequestBody PaymentRequest paymentRequest)
	{
		paymentService.pay();
		
		return ResponseEntity.ok(null);
	}
}
