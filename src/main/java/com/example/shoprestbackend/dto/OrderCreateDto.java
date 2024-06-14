package com.example.shoprestbackend.dto;

import lombok.Data;

@Data
public class OrderCreateDto {
    private Long amount;
    private Long userId;
    private Long productId;
}
