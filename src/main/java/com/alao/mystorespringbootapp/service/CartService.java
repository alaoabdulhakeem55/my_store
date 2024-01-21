package com.alao.mystorespringbootapp.service;

import com.alao.mystorespringbootapp.entity.Cart;
import org.springframework.stereotype.Service;


public interface CartService {
//    Cart addToCart(Long customerId, Long productId, int quantity);
//    Cart reduceCartQuantity(Long productId, Long userId, int quantity);
    Object findAll();
    Cart findByUserId(Long customerId);
    Cart save(Cart cart);
    void addProductToCart(Long productId, Long customerId);
}
