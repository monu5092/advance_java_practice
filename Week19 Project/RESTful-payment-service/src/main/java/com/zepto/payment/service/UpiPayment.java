package com.zepto.payment.service;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Primary
@Service
public class UpiPayment implements PaymentService {

	
	@Override
	public void pay() {
		// TODO Auto-generated method stub
		System.out.println("UpiPayment.pay()");
	}

}
