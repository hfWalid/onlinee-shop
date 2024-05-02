package com.onlineshop.productservice.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "product")
public class Product {

    @Id
    @GeneratedValue
    private Long id;

    private String name;
    private String description;
    private Long price;
    private Integer stockQuantity;
    private LocalDateTime createdAt;
    private LocalDateTime updated_at;
}
