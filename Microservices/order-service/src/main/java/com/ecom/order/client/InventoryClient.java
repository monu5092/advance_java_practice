package com.ecom.order.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;




@FeignClient(name="inventory-service",url="http://localhost:8084")
public interface InventoryClient {
	
	@GetMapping("/{productId}")
	public ResponseEntity<InventoryDto> getInventory(@PathVariable Long productId);
	
	@PutMapping("/reduce")
    public ResponseEntity<String> reduceStock(@RequestBody InventoryRequest request);
	
}
