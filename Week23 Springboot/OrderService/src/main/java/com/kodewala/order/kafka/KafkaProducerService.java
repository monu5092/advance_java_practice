package com.kodewala.order.kafka;

import java.util.concurrent.ExecutionException;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.kodewala.order.traceconfig.TraceFeingConfig;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;

@Service
public class KafkaProducerService {
	
	private final TraceFeingConfig traceFeingConfig;
    
	private static final String Topic = "order-placed";
	
	private final KafkaTemplate<String, String> kafkaTemplate;
	
	public KafkaProducerService(KafkaTemplate<String, String> kafkaTemplate, TraceFeingConfig traceFeingConfig )
	{
		this.kafkaTemplate = kafkaTemplate;
		this.traceFeingConfig = traceFeingConfig;
	}
	
	
	@Retry(name = "kafakRetry" , fallbackMethod = "kafkaFallback")
	@CircuitBreaker(name ="kafkaPublisher" ,fallbackMethod = "kafkaFallback")
	public void sendMessage(String message)
	{
		System.out.println("KafkaProducerService.sendMessage() sending message to kafka...");
		try {
			kafkaTemplate.send(Topic,message).get();
		}catch(InterruptedException | ExecutionException e)
		{
			e.printStackTrace();
		}
		System.out.println("Sent message to Kafka: "+message);
	}
	
	public void kafkaFallback(String message, Throwable ex) {
		System.out.println("Kafka failed after retries. CircuitBreaker triggered.");
		System.out.println("Reason: " + ex.getMessage());
	}

	
	
}
