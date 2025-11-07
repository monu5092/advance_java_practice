package com.kodewala;

public class Order {
    
	private String orderName;
	private String orderId;
	private int price;
	
	public String getOrderName() {
		return orderName;
	}
	public void setOrderName(String orderName) {
		this.orderName = orderName;
	}
	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
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
		return ("OrderName -> "+orderName+"\nOrderId -> "+orderId+"\nPrice ->"+price);
	}
	
}
