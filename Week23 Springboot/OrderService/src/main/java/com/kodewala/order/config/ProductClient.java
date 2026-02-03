package com.kodewala.order.config;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.kodewala.order.dto.Product;
import com.kodewala.order.traceconfig.TraceFeingConfig;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;



@FeignClient(name ="ProductServiceFeign",configuration = TraceFeingConfig.class)
public interface ProductClient {
     
	@CircuitBreaker(name = "productServiceCB", fallbackMethod="fallbackProduct")
	@Retry(name = "productServiceRetry")
	@GetMapping("products/{id}")
	Product getProduct(@PathVariable Long id);
	
	default Product Fallback(Long id,Throwable ex)
	{
		throw new RuntimeException("Product service is unavailable");
	}
	
}
