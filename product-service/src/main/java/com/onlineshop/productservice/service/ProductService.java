package com.onlineshop.productservice.service;

import com.onlineshop.productservice.dto.ProductDTO;

public interface ProductService {
    ProductDTO getProductById(Long productId);
}
