package com.ecom.payment.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecom.payment.entity.Payment;
import com.ecom.payment.exception.PaymentFailedException;
import com.ecom.payment.kafka.PaymentProducer;
import com.ecom.payment.repository.PaymentRepository;
import com.ecom.payment.request.PaymentRequest;

@Service
public class PaymentService {
    
			@Autowired
			PaymentRepository paymentRepository;
			
			@Autowired
			PaymentProducer paymentProducer;

    
			
			public Payment processPayment(PaymentRequest request)
			{
				Payment payment = new Payment();
				payment.setOrderId(request.getOrderId());
				payment.setAmount(request.getAmount());
				
				if(request.getAmount()<=0)
				{
					payment.setStatus("FAILED");
					paymentRepository.save(payment);
					paymentProducer.sendPaymentSuccess(request.getOrderId());
					throw new PaymentFailedException("Paymment Failed");
				}
				
				payment.setStatus("SUCCESS");
					
				Payment savedPayment = paymentRepository.save(payment);
				
				paymentProducer.sendPaymentSuccess(request.getOrderId());

		        return savedPayment;
			}
	
	
}
