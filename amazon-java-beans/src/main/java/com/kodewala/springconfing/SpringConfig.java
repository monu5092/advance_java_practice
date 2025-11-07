package com.kodewala.springconfing;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.kodewala.Order;


@Configuration
public class SpringConfig {

	  @Bean("order")
	  public Order orderConfig()
	  {
		  Order order = new Order();
		  order.setOrderName("Laptop");
		  order.setOrderId("Asus123");
		  order.setPrice(700000);
		  return order;  
	  }
}
