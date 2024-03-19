package com.onlineshop.cartservice.client;

import com.onlineshop.cartservice.dto.ProductDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "product-service", url = "${application.config.products-url}")
public interface ProductClient {

    @GetMapping("/cart/{cartId}")
    List<ProductDTO> findAllProductsByCartId(@PathVariable("cartId") Long cartId);
}
