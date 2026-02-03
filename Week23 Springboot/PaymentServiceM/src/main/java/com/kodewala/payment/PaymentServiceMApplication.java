package com.kodewala.payment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class PaymentServiceMApplication {

	public static void main(String[] args) {
		SpringApplication.run(PaymentServiceMApplication.class, args);
	}

}
