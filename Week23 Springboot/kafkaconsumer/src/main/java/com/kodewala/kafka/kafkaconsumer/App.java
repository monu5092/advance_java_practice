package com.kodewala.kafka.kafkaconsumer;

import java.util.Properties;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;

public class App 
{
    public static void main( String[] args )
    {
        Properties props = new Properties();
        props.setProperty(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG,"localhost:9092");
        props.setProperty(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG,StringSerializer.class.getName());
        props.setProperty(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG,StringSerializer.class.getName());
        
        KafkaProducer  producer = new KafkaProducer(props);
        
        for(int i=0;i<10;i++)
        {
        	ProducerRecord record = new ProducerRecord("order", "order2"+i+ " Test ORDERRRRRR "+i);
        	producer.send(record);
        }
        
        producer.flush();
        
        producer.close();
        
        System.out.println("Message have been sent to kafka successfully!");
    }
}
