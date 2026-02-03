package com.ecom.inventory.service;

import org.springframework.stereotype.Service;

import com.ecom.inventory.entity.Inventory;
import com.ecom.inventory.exception.InventoryNotFoundException;
import com.ecom.inventory.repository.InventoryRepository;
import com.ecom.inventory.request.InventoryRequest;

@Service
public class InventoryService {

	private final InventoryRepository inventoryRepository;

	public InventoryService(InventoryRepository inventoryRepository) {
		this.inventoryRepository = inventoryRepository;
	}

	public String reduceStock(InventoryRequest request) {
		Inventory inventory = inventoryRepository.findByProductId(request.getProductId())
				.orElseThrow(() -> new InventoryNotFoundException("Product not found in inventory"));

		if (inventory.getQuantity() < request.getQuantity()) {
			throw new RuntimeException("Insufficient stock");
		}

		inventory.setQuantity(inventory.getQuantity() - request.getQuantity());
		inventoryRepository.save(inventory);

		return "Stock updated successfully";
	}
	
	
	public Inventory getInventory(Long productId) {
        return inventoryRepository.findByProductId(productId)
                .orElseThrow(() ->
                        new InventoryNotFoundException("Inventory not found"));
    }
}
