package com.kodewala.producer.kafka.response;

public class OrderResponse {
	
	private Long orderId;
	private String customerId;
	private String paymentStatus;
	
	
	public Long getOrderId() {
		return orderId;
	}
	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}
	public String getCustomerId() {
		return customerId;
	}
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
	public String getPaymentStatus() {
		return paymentStatus;
	}
	public void setPaymentStatus(String paymentStatus) {
		this.paymentStatus = paymentStatus;
	}
	
	
	@Override
	public String toString() {
		return  "orderId=" + orderId +
		           ", customerId=" + customerId +
		           ", paymentStatus=" + paymentStatus;
	}
	
	
	
	

}
