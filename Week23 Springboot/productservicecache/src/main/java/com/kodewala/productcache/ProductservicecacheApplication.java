package com.kodewala.productcache;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class ProductservicecacheApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProductservicecacheApplication.class, args);
	}

}
