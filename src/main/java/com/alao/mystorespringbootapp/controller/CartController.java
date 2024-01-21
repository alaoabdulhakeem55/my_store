package com.alao.mystorespringbootapp.controller;

import com.alao.mystorespringbootapp.dto.CartDto;
import com.alao.mystorespringbootapp.entity.Cart;
import com.alao.mystorespringbootapp.entity.Customer;
import com.alao.mystorespringbootapp.exceptions.NotFoundException;
import com.alao.mystorespringbootapp.service.CartService;
import com.alao.mystorespringbootapp.service.CustomerService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
@RequestMapping("/api")
public class CartController {
    private CartService cartService;
    private CustomerService customerService;

    @PostMapping("/carts")
    public String addProductToCart(@RequestParam Long productId, @RequestParam Long customerId) {

        cartService.addProductToCart(productId, customerId);
        return "Product added successfully to cart for customer " + customerId;
    }

    @GetMapping("/carts")
    public Object findAll() {
        return cartService.findAll();
    }

    @GetMapping("/carts/{customerId}")
    public Cart findByUserId(@PathVariable Long customerId) {
        Cart cart = cartService.findByUserId(customerId);

        if (cart == null) {
            throw new NotFoundException("Cart " + customerId + " not found.");
        }
        return cart;
    }

}
