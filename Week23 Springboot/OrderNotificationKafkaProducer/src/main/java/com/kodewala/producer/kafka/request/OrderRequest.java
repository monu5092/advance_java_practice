package com.kodewala.producer.kafka.request;

import java.util.ArrayList;

public class OrderRequest {
     
	private String customerId;
	private ArrayList<String> products;
	private ArrayList<Double> prices;
	private Integer totalPrice;
	private String pymentStatus;
	public String getCustomerId() {
		return customerId;
	}
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
	public ArrayList<String> getProducts() {
		return products;
	}
	public void setProducts(ArrayList<String> products) {
		this.products = products;
	}
	public ArrayList<Double> getPrices() {
		return prices;
	}
	public void setPrices(ArrayList<Double> prices) {
		this.prices = prices;
	}
	public Integer getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(Integer totalPrice) {
		this.totalPrice = totalPrice;
	}
	public String getPymentStatus() {
		return pymentStatus;
	}
	public void setPymentStatus(String pymentStatus) {
		this.pymentStatus = pymentStatus;
	}
	
	
	
}
