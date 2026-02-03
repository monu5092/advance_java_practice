package com.kodekart.service;

import java.util.List;

import com.kodekart.dao.CartDao;
import com.kodekart.model.Cart;

public class CartService {

	private CartDao cartDao = new CartDao();

	
	public boolean addTocart(Cart cart) {

		Cart existing = cartDao.getCartItem(cart.getUserId(), cart.getProductId());

		if (existing != null) {
			int newQty = existing.getQuantity() + cart.getQuantity();
			return cartDao.updateQuantity(existing.getId(), newQty);
		}

		return cartDao.addToCart(cart);
	}

	
	public List<Cart> getCart(int userId) {
		return cartDao.getCart(userId);
	}

	
	public double calculateTotal(int userId) {
		List<Cart> items = cartDao.getCart(userId);
		double total = 0;

		for (Cart item : items) {
			total += item.getTotalPrice(); 
		}

		return total;
	}

	
	public boolean removeFromCart(int cartId) {
		return cartDao.removeCartItem(cartId);
	}

	
	public boolean clearCart(int userId) {
		return cartDao.clearCart(userId);
	}
}
