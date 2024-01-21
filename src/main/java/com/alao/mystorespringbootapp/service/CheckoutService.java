package com.alao.mystorespringbootapp.service;

import com.alao.mystorespringbootapp.entity.Cart;
import com.alao.mystorespringbootapp.entity.Checkout;
import org.springframework.stereotype.Service;

@Service
public interface CheckoutService {
    Checkout initiateCheckout(Cart cart);
    Checkout finaliseCheckout(Checkout checkout);
}
