package com.alao.mystorespringbootapp.service;

import com.alao.mystorespringbootapp.entity.Order;
import org.springframework.stereotype.Service;

@Service
public interface OrderService {
    Order cancelOrder(String orderId);
    Order retrieveOrder(String orderId);
    Object retrieveUserOrder(String orderId);
}
