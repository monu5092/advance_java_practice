package com.kodekart.service;

import java.sql.Date;
import java.util.List;

import com.kodekart.dao.CartDao;
import com.kodekart.dao.OrderDao;
import com.kodekart.model.Cart;
import com.kodekart.model.Order;

public class OrderService {
	
    private OrderDao orderDao = new OrderDao();
    private CartDao cartDao =  new CartDao();
    
	public boolean placeOrder(int userId) {

		List<Cart> cartItems = cartDao.getCart(userId);

		if (cartItems.isEmpty()) {
			return false; 
		}

		double total=0.0;
		for (Cart c : cartItems) {
			total += c.getTotalPrice();
		}

		Order order = new Order();
		order.setUserId(userId);
		order.setOrderDate(new Date(System.currentTimeMillis()));
		order.setTotalAmount(total);

		boolean saved = orderDao.saveOrder(order);

		if (saved) {
			cartDao.clearCart(userId); 
		}

		return saved;
	}
    
	public List<Order> getOrdersByUser(int userId) {
		return orderDao.getOrdersByUser(userId);
	}
	
	public List<Order> viewAllOrders() {
		return orderDao.getAllOrders();
	}
}
