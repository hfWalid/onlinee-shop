package com.onlineshop.cartservice.client;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name = "product-service", url = "${application.config.products-url}")
public interface ProductClient {
}
