package com.ecom.cart.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecom.cart.entity.Cart;
import com.ecom.cart.request.AddToCartRequest;
import com.ecom.cart.request.RemoveFromCartRequest;
import com.ecom.cart.service.CartService;

@RestController
@RequestMapping("/cart")
public class CartController {
      
	   @Autowired
	   CartService cartService;
	   
	   @PostMapping("/add")
	   public ResponseEntity<Cart> addToCart(@RequestBody AddToCartRequest request)
	   {
		   return ResponseEntity.ok(cartService.addToCart(request));
	   }
	   
	   @DeleteMapping("/remove")
	   public ResponseEntity<Cart> removeFromCart(@RequestBody RemoveFromCartRequest request)
	   {
		   return ResponseEntity.ok(cartService.removeFromCart(request));
	   }
}
