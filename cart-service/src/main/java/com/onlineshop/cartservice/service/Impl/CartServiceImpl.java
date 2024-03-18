package com.onlineshop.cartservice.service.Impl;

import com.onlineshop.cartservice.dto.CartDTO;
import com.onlineshop.cartservice.model.Cart;
import com.onlineshop.cartservice.repository.CartRepository;
import com.onlineshop.cartservice.service.CartService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Optional;

@AllArgsConstructor
@Service
public class CartServiceImpl implements CartService {
    private final CartRepository cartRepository;
    private final ModelMapper modelMapper;

    public CartDTO getCartById(Long cartId){
        Cart retrievedCart = cartRepository.findById(cartId).orElse(null);

        return retrievedCart != null ? modelMapper.map(Optional.of(retrievedCart), CartDTO.class) : null;
    }
}
