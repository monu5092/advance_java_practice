package com.ecom.notification.service;

import org.springframework.stereotype.Service;

@Service
public class NotificationService {
	public void sendOrderNotification(String message) {
        System.out.println("📧 Email Sent: Order Notification -> " + message);
        System.out.println("📱 SMS Sent: Order Notification -> " + message);
    }

    public void sendPaymentNotification(String message) {
        System.out.println("📧 Email Sent: Payment Notification -> " + message);
        System.out.println("📱 SMS Sent: Payment Notification -> " + message);
    }
}
