package com.onlineshop.productservice.service.Impl;

import com.onlineshop.productservice.dto.ProductDTO;
import com.onlineshop.productservice.model.Product;
import com.onlineshop.productservice.repository.ProductRepository;
import com.onlineshop.productservice.service.ProductService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;
    private ModelMapper modelMapper;

    public ProductDTO getProductById(Long productId){
        Product retrievedProduct = productRepository.findById(productId).orElse(null);

        return retrievedProduct != null ? modelMapper.map(retrievedProduct, ProductDTO.class) : null;
    }
}
