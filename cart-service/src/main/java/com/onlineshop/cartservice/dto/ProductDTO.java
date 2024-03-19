package com.onlineshop.cartservice.dto;


import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Null;
import jakarta.validation.constraints.PastOrPresent;
import lombok.*;

import java.time.LocalDateTime;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductDTO {

    @Null(message = "Product ID should not be provided for new events")
    private Long id;


    @Null(message = "Cart ID should not be provided for new events")
    private String name;

    @Null(message = "Cart ID should not be provided for new events")
    private String description;

    @Null(message = "Cart ID should not be provided for new events")
    private Long price;

    @Null(message = "Cart ID should not be provided for new events")
    private Integer stockQuantity;
    @NotNull(message = "Creation time is required")
    @PastOrPresent(message = "Creation time must be in the past or present")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    private LocalDateTime createdAt;
    @NotNull(message = "Update time is required")
    @PastOrPresent(message = "Update time must be in the past or present")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    private LocalDateTime updatedAt;
}

