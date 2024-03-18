package com.onlineshop.productservice.controller;

import com.onlineshop.productservice.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/products")
@AllArgsConstructor
public class ProductController {
    private final ProductService productService;
}
