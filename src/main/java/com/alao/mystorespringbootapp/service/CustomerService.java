package com.alao.mystorespringbootapp.service;

import com.alao.mystorespringbootapp.dto.CustomerRequest;
import com.alao.mystorespringbootapp.entity.Customer;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface CustomerService {
    Customer removeCustomer(Long id);
    Object findAll();
    Optional<Customer> findById(Long id);
    Customer saveCustomer(CustomerRequest request);
    Customer updateCustomer(CustomerRequest request);
//    void addToCart(Long customerId, Long productId, int quantity);
//    void reduceCartQuantity(Long customerId, Long productId, int quantity);

}
