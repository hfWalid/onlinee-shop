package com.onlineshop.cartservice.controller;

import com.onlineshop.cartservice.service.CartService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/carts")
@AllArgsConstructor
public class CartController {
    private final CartService cartService;
}
