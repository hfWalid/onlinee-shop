package com.onlineshop.cartservice.service.Impl;

import com.onlineshop.cartservice.client.ProductClient;
import com.onlineshop.cartservice.dto.CartDTO;
import com.onlineshop.cartservice.dto.ProductDTO;
import com.onlineshop.cartservice.model.Cart;
import com.onlineshop.cartservice.repository.CartRepository;
import com.onlineshop.cartservice.service.CartService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class CartServiceImpl implements CartService {
    private final CartRepository cartRepository;
    private final ProductClient productClient;
    private final ModelMapper modelMapper;

    public CartDTO getCartById(Long cartId){
        Cart retrievedCart = cartRepository.findById(cartId).orElse(null);

        return retrievedCart != null ? modelMapper.map(Optional.of(retrievedCart), CartDTO.class) : null;
    }

    public CartDTO getCartWithProducts(Long cartId){
        List<ProductDTO> productDTOS =  productClient.findAllProductsByCartId(cartId);
        return CartDTO.builder()
                .id(1L)
                .createdAt(LocalDateTime.of(2024, Month.JANUARY, 29, 19, 30, 40))
                .updatedAt(LocalDateTime.of(2024, Month.MARCH, 1, 19, 30, 40))
                .products(productDTOS)
                .build();
    }
}
