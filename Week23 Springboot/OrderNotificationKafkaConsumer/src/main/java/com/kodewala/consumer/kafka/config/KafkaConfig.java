package com.kodewala.consumer.kafka.config;

import java.util.Properties;

import com.kodewala.consumer.kafka.OrderNotificationKafkaConsumerApplication;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class KafkaConfig {

    private final OrderNotificationKafkaConsumerApplication orderNotificationKafkaConsumerApplication;

    KafkaConfig(OrderNotificationKafkaConsumerApplication orderNotificationKafkaConsumerApplication) {
        this.orderNotificationKafkaConsumerApplication = orderNotificationKafkaConsumerApplication;
    }

	@Bean
	public KafkaConsumer<String,String> kafkaConsumer()
	{
		Properties props = new Properties();
		
		props.setProperty(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
		props.setProperty(ConsumerConfig.GROUP_ID_CONFIG,"notification-g-1");
		props.setProperty(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
		props.setProperty(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG,StringDeserializer.class.getName());
		
		return new KafkaConsumer<>(props);
	}
}
