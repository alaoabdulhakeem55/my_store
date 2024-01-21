package com.alao.mystorespringbootapp.dto;

import lombok.Getter;

@Getter
public class CartDto {
    private Long customerId;
    private Long productId;
    private int quantity;

}
