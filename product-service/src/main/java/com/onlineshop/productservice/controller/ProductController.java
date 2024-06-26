package com.onlineshop.productservice.controller;

import com.onlineshop.productservice.common.dto.ResponseObject;
import com.onlineshop.productservice.dto.ProductDTO;
import com.onlineshop.productservice.service.ProductService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.List;

@RestController
@RequestMapping("/api/v1/products")
@AllArgsConstructor
public class ProductController {
    private final ProductService productService;

    @GetMapping("/{productId}")
    @Operation(summary = "Product retrieve", description = "Get an Product by providing its id", tags = { "GET" })
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "Successfully retrieved")})
    public ResponseObject<ProductDTO> getProductById(@PathVariable Long productId) {
        ProductDTO productDTO = ProductDTO.builder()
                .id(1L)
                .name("product 1")
                .description("product 1 desc")
                .price(20L)
                .stockQuantity(345)
                .createdAt(LocalDateTime.of(2024, Month.JANUARY, 29, 19, 30, 40))
                .updatedAt(LocalDateTime.of(2024, Month.MARCH, 1, 19, 30, 40))
                .build();
        //productService.getProductById(productId);
        if (productDTO != null) {
            return new ResponseObject<>(true, "Product retrieved successfully", productDTO);
        } else {
            return new ResponseObject<>(false, "Product not found", null);
        }
    }

    @GetMapping("/cart/{cartId}")
    @Operation(summary = "Products retrieve", description = "Get all Products by providing its cartId", tags = { "GET" })
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "Successfully retrieved")})
    public List<ProductDTO> getProductsByCardId(@PathVariable Long cartId) {
        ProductDTO productDTO = ProductDTO.builder()
                .id(1L)
                .name("product 112")
                .description("product 112 desc")
                .price(20L)
                .stockQuantity(666)
                .createdAt(LocalDateTime.of(2024, Month.JANUARY, 29, 19, 30, 40))
                .updatedAt(LocalDateTime.of(2024, Month.MARCH, 1, 19, 30, 40))
                .build();
        //productService.getProductById(productId);
        if (productDTO != null) {
            return List.of(productDTO);
        } else {
            return null;
        }
    }
}
