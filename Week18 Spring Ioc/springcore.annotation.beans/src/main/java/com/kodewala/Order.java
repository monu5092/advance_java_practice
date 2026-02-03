package com.kodewala;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Order {
    
	@Value("100")
	private int orderId;
	
	@Value("Samsung")
	private String orderName;
	
	@Value("72000")
	private int price;

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public String getOrderName() {
		return orderName;
	}

	public void setOrderName(String orderName) {
		this.orderName = orderName;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return ("OrderId -> "+orderId+"\nOrderName ->"+orderName+"\nPrice"+price);
	}
}
