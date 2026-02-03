package com.kodewala.order.response;

import com.kodewala.order.entity.Order;

public class OrderResponse {

	private String message;
	private Order order;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

}
