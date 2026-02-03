package com.kodewala.consumer.kafka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class OrderNotificationKafkaConsumerApplication {

	public static void main(String[] args) {
		SpringApplication.run(OrderNotificationKafkaConsumerApplication.class, args);
	}

}
