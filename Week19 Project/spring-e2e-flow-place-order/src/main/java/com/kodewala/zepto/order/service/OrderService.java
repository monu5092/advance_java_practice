package com.kodewala.zepto.order.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kodewala.zepto.order.bean.OrderInfo;
import com.kodewala.zepto.order.controller.OrderController;
import com.kodewala.zepto.order.dao.OrderDao;
import com.kodewala.zepto.order.entity.Order;

@Service
public class OrderService {

	private final OrderController orderController;
	
	@Autowired
	OrderDao orderDao;
	
	public OrderService(OrderController orderController) {
		this.orderController = orderController;
	}
	
	public int createOrder(OrderInfo orderInfo)
	{
		System.out.println("OrderService : Item Name "+orderInfo.getItem());
		
		Order orderEntity = new Order(); 
		
		orderEntity.setItem(orderInfo.getItem());
		orderEntity.setQty(orderInfo.getQty());
		orderEntity.setPrice(orderInfo.getPrice());
		orderEntity.setAddress(orderInfo.getAddress());
		
		int orderId = orderDao.saveOrder(orderEntity);
		return orderId;
	}
	
}
