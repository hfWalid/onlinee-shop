package com.onlineshop.cartservice.client;

import com.onlineshop.cartservice.config.loadBalancing.RibbonConfiguration;
import com.onlineshop.cartservice.dto.ProductDTO;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "product-service", url = "${application.config.products-url}")
@RibbonClient(name = "product-service", configuration = RibbonConfiguration.class)
public interface ProductClient {
    
    @GetMapping("/cart/{cartId}")
    List<ProductDTO> findAllProductsByCartId(@PathVariable("cartId") Long cartId);
}
