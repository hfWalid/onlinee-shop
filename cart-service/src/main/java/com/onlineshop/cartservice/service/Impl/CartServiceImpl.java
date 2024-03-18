package com.onlineshop.cartservice.service.Impl;

import com.onlineshop.cartservice.repository.CartRepository;
import com.onlineshop.cartservice.service.CartService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class CartServiceImpl implements CartService {
    private final CartRepository cartRepository;
    private final ModelMapper modelMapper;
}
