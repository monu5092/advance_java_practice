package com.kodewala.producer.kafka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class OrderNotificationKafkaProducerApplication {

	public static void main(String[] args) {
		SpringApplication.run(OrderNotificationKafkaProducerApplication.class, args);
	}

}
