package com.kodewala.payment.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kodewala.payment.entity.Payment;
import com.kodewala.payment.repository.PaymentRepository;

@Service
public class PaymentService {
     
	@Autowired
	PaymentRepository paymentRepository;
	
	
	public Payment doPayent(Payment payment)
	{
		return paymentRepository.save(payment);
	}
	
	public Payment getPaymentByOrderId(Long orderId)
	{
		return paymentRepository.findByOrderId(orderId);
	}
}
