package com.onlineshop.productservice.service.Impl;

import com.onlineshop.productservice.repository.ProductRepository;
import com.onlineshop.productservice.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;
}
