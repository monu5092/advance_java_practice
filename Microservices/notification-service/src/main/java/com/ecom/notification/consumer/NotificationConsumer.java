package com.ecom.notification.consumer;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.ecom.notification.service.NotificationService;

@Service
public class NotificationConsumer {
	private final NotificationService notificationService;

    public NotificationConsumer(NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    @KafkaListener(topics = "ORDER_CREATED", groupId = "notification-group")
    public void consumeOrderCreated(String message) {
        notificationService.sendOrderNotification(message);
    }

    @KafkaListener(topics = "PAYMENT_SUCCESS", groupId = "notification-group")
    public void consumePaymentSuccess(String message) {
        notificationService.sendPaymentNotification(message);
    }
}
