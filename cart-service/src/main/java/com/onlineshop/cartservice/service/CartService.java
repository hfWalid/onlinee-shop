package com.onlineshop.cartservice.service;

import com.onlineshop.cartservice.dto.CartDTO;

public interface CartService {
    CartDTO getCartById(Long cartId);
    CartDTO getCartWithProducts(Long cartId);
}
