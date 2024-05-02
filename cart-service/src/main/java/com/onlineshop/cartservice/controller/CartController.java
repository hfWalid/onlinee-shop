package com.onlineshop.cartservice.controller;

import com.onlineshop.cartservice.common.dto.ResponseObject;
import com.onlineshop.cartservice.dto.CartDTO;
import com.onlineshop.cartservice.service.CartService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.AllArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.Date;
import java.util.Locale;

@RestController
@RequestMapping("/api/v1/carts")
@AllArgsConstructor
public class CartController {
    private final CartService cartService;
    private final MessageSource messageSource;

    @GetMapping("/{cartId}")
    @Operation(summary = "Cart retrieve", description = "Get an Cart by providing its id", tags = { "GET" })
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "Successfully retrieved")})
    public ResponseObject<CartDTO> getCartById(@PathVariable Long cartId) {
        CartDTO cart = CartDTO.builder()
                .id(1L)
                .createdAt(LocalDateTime.of(2024, Month.JANUARY, 29, 19, 30, 40))
                .updatedAt(LocalDateTime.of(2024, Month.MARCH, 1, 19, 30, 40))
                .build();
        CartDTO cartWithProducts = cartService.getCartWithProducts(cartId);
        if (cart != null) {
            return new ResponseObject<>(true, "Cart retrieved successfully", cartWithProducts);
        } else {
            return new ResponseObject<>(false, "Cart not found", null);
        }
    }

    @GetMapping("/locale")
    public String sayHello(
            @RequestHeader(name="Accept-Language", required= false)
            Locale locale
    ){
        return messageSource.getMessage("common.hello", null, LocaleContextHolder.getLocale());
    }
}
