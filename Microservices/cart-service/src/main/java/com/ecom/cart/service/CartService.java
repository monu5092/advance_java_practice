package com.ecom.cart.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecom.cart.entity.Cart;
import com.ecom.cart.entity.CartItem;
import com.ecom.cart.exception.CartNotFoundException;
import com.ecom.cart.repository.CartRepository;
import com.ecom.cart.request.AddToCartRequest;
import com.ecom.cart.request.RemoveFromCartRequest;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class CartService {
    
		   @Autowired
		   CartRepository cartRepository;
	  
		    
		    public Cart addToCart(AddToCartRequest request) {

		        Cart cart = cartRepository.findByUserId(request.getUserId())
		                .orElseGet(() -> {
		                    Cart c = new Cart();
		                    c.setUserId(request.getUserId());
		                    return cartRepository.save(c);
		                });

		        Optional<CartItem> existingItem = cart.getItems().stream()
		                .filter(i -> i.getProductId().equals(request.getProductId()))
		                .findFirst();

		        if (existingItem.isPresent()) {
		            CartItem item = existingItem.get();
		            item.setQuantity(item.getQuantity() + request.getQuantity());
		        } else {
		            CartItem item = new CartItem();
		            item.setProductId(request.getProductId());
		            item.setQuantity(request.getQuantity());
		            item.setCart(cart);
		            cart.getItems().add(item);
		        }

		        return cartRepository.save(cart);
		    }
		    
		    public Cart removeFromCart(RemoveFromCartRequest request) {

		        Cart cart = cartRepository.findByUserId(request.getUserId())
		                .orElseThrow(() -> new CartNotFoundException("Cart not found"));

		        cart.getItems().removeIf(
		                item -> item.getProductId().equals(request.getProductId())
		        );

		        return cartRepository.save(cart);
		    }
}
