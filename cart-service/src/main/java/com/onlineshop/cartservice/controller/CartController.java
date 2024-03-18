package com.onlineshop.cartservice.controller;

import com.onlineshop.cartservice.common.dto.ResponseObject;
import com.onlineshop.cartservice.dto.CartDTO;
import com.onlineshop.cartservice.service.CartService;
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
import java.util.Date;

@RestController
@RequestMapping("/api/v1/carts")
@AllArgsConstructor
public class CartController {
    private final CartService cartService;

    @GetMapping("/{cartId}")
    @Operation(summary = "Cart retrieve", description = "Get an Cart by providing its id", tags = { "GET" })
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "Successfully retrieved")})
    public ResponseObject<CartDTO> getCartById(@PathVariable Long cartId) {
        CartDTO cart = CartDTO.builder()
                .id(1L)
                .createdAt(LocalDateTime.of(2024, Month.JANUARY, 29, 19, 30, 40))
                .updatedAt(LocalDateTime.of(2024, Month.MARCH, 1, 19, 30, 40))
                .build();
        //cartService.getCartById(cartId);
        if (cart != null) {
            return new ResponseObject<>(true, "Cart retrieved successfully", cart);
        } else {
            return new ResponseObject<>(false, "Cart not found", null);
        }
    }
}
