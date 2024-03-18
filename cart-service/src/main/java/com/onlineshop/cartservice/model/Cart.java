package com.onlineshop.cartservice.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "cart")
public class Cart {

    @Id
    @GeneratedValue
    private Long id;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
