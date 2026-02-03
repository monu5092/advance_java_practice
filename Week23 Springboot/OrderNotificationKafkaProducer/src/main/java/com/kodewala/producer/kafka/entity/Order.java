package com.kodewala.producer.kafka.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Table;

@Entity
@Table(name="order")
public class Order {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long orderId;
	
	@Column
	private String customerId;
	
	@ElementCollection
	@CollectionTable(name="order_product",joinColumns = {@JoinColumn(name="order_id")})
	@Column(name="product_name")
	private List<String> productList;
	
	@ElementCollection
	@CollectionTable(name="order_price",joinColumns = {@JoinColumn(name="order_id")})
	private List<Double>prices;
	
	@Column
	private Integer totalPrice;
	
	@Column
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

	public List<String> getProductList() {
		return productList;
	}

	public void setProductList(List<String> productList) {
		this.productList = productList;
	}

	public List<Double> getPrices() {
		return prices;
	}

	public void setPrices(List<Double> prices)
	{
		 this.prices = prices;
	}

	public Integer getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(Integer totalPrice) {
		this.totalPrice = totalPrice;
	}

	public String getPaymentStatus() {
		return paymentStatus;
	}

	public void setPaymentStatus(String paymentStatus) {
		this.paymentStatus = paymentStatus;
	}
	
	
	
	
	
	
	
	
}
