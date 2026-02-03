package com.ecom.inventory.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecom.inventory.entity.Inventory;
import com.ecom.inventory.request.InventoryRequest;
import com.ecom.inventory.service.InventoryService;

@RestController
@RequestMapping("inventory")
public class InventoryController {
	
	private final InventoryService inventoryService;
	
	public InventoryController(InventoryService inventoryService)
	{
		this.inventoryService = inventoryService;
	}
	
		@GetMapping("/{productId}")
		public ResponseEntity<Inventory> getInventory(@PathVariable Long productId)
		{
		return ResponseEntity.ok(inventoryService.getInventory(productId));
	    }
	
	
	@PutMapping("/reduce")
    public ResponseEntity<String> reduceStock(@RequestBody InventoryRequest request) {
        return ResponseEntity.ok(inventoryService.reduceStock(request));
    }

}
