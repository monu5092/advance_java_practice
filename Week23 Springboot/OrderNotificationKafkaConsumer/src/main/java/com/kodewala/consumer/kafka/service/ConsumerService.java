package com.kodewala.consumer.kafka.service;

import java.time.Duration;
import java.util.Arrays;
import java.util.Collection;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.kodewala.consumer.kafka.config.KafkaConfig;
import com.kodewala.consumer.kafka.entity.ConsumerNotification;
import com.kodewala.consumer.kafka.repository.ConsumerRepository;

import jakarta.annotation.PostConstruct;

@Service
public class ConsumerService {

    private final KafkaConfig kafkaConfig;

	@Autowired
	ConsumerRepository consumerRepository ;
	
	@Autowired
	KafkaConsumer<String,String> consumer;

    ConsumerService(KafkaConfig kafkaConfig) {
        this.kafkaConfig = kafkaConfig;
    }
	
	@PostConstruct
	public void startConsumer() {
	    createNotification();
	}
	
	public void createNotification() {
		
	    System.out.println("Notification created");
	    
	    
	    Collection<String> topicList = Arrays.asList("order_event");
	    consumer.subscribe(topicList);
	    
	    while(true)
	    {
	      ConsumerRecords<String, String> records = consumer.poll(Duration.ofMillis(1000));
	      
	      for(ConsumerRecord<String, String> record : records)
	      {
	    	  System.out.println("message offSet: "+record.offset());
	    	  System.out.println("message key: "+record.key());
	    	  System.out.println("message value: "+record.value());
	    	  
	    	  
	    	  ConsumerNotification notification = new ConsumerNotification();
	    	  
	    	  String[] msg = record.value().split(",");
	    	  
	    	  notification.setOrderId(msg[0]);
	    	  notification.setCutomerId(msg[1]);
	    	  notification.setPaymentStatus(msg[2]);
	    	  
	    	  
	    	  consumerRepository.save(notification);
	      }
	      
	    }
		
	}

	
	
}
