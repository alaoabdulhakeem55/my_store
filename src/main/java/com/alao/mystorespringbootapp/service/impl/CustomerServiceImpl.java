package com.alao.mystorespringbootapp.service.impl;

import com.alao.mystorespringbootapp.dao.CustomerRepo;
import com.alao.mystorespringbootapp.dto.CustomerRequest;
import com.alao.mystorespringbootapp.entity.Customer;
import com.alao.mystorespringbootapp.exceptions.AppException;
import com.alao.mystorespringbootapp.exceptions.NotFoundException;
import com.alao.mystorespringbootapp.service.CustomerService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@AllArgsConstructor
public class CustomerServiceImpl implements CustomerService {
    private final CustomerRepo customerRepo;
 //   private final CartService cartService;


 //   @Transactional
//    @Override
//    public Customer addCustomer() {
//        Customer customer = customerRepo.findByEmail(customer.getEmail());
//        if(customer != null) {
//            throw new AppException("Email already taken");
//
//        }
//        Customer newCustomer= new Customer();
//        return customerRepo.save(newCustomer);
//    }

    @Transactional
    @Override
    public Customer removeCustomer(Long id) {
        Optional<Customer> optionalCustomer = customerRepo.findById(id);
        if (optionalCustomer.isPresent()) {
            Customer customer = optionalCustomer.get();
            customerRepo.deleteById(id);
            return customer;
        } else {
            throw new NotFoundException("Customer not found with ID: " + id);
        }
    }

    @Override
    public Object findAll() {
        return customerRepo.findAll();
    }


    @Override
    public Optional<Customer> findById(Long id) {
        Optional<Customer> result = customerRepo.findById(id);

        Customer customer = null;

        if (result.isPresent()) {
            customer = result.get();
        }
        else {

            throw new NotFoundException("Customer " + id +  " not found.");
        }

        return Optional.of(customer);
    }

    @Override
    public Customer saveCustomer(CustomerRequest request) {
        if(request.getEmail() != null){
            throw new AppException("Customer already exist with this email " + request.getEmail());
        }

        Customer customer = new Customer();
        customer.setName(request.getName());
        customer.setEmail(request.getEmail());
        customer.setAddress(request.getAddress());

        return customerRepo.save(customer);
    }

    @Override
    public Customer updateCustomer(CustomerRequest request) {

        if(request.getEmail() == null){
            throw new AppException("Customer not found.");
        }
        Customer customer = new Customer();
        customer.setName(request.getName());
        // To restrict items to be updated
//        customer.setEmail(request.getEmail());
        customer.setAddress(request.getAddress());
        return customerRepo.save(customer);
    }

//    @Transactional
//    @Override
//    public void addToCart(Long customerId, Long productId, int quantity) {
//        Optional<Customer> optionalCustomer = customerRepo.findById(customerId);
//        if (optionalCustomer.isPresent()) {
//            Customer customer = optionalCustomer.get();
//            Cart cart = customer.getCart();
//
//            if (cart == null) {
//                cart = new Cart();
//                customer.setCart(cart);
//            }
//
//            cartService.addToCart(cart.getId(), productId, quantity);
//
//            customerRepo.save(customer);
//        } else {
//            throw new NotFoundException("Customer not found with ID: " + customerId);
//        }
//    }
//
//    @Transactional
//    @Override
//    public void reduceCartQuantity(Long customerId, Long productId, int quantity) {
//        Optional<Customer> optionalCustomer = customerRepo.findById(customerId);
//        if (optionalCustomer.isPresent()) {
//            Customer customer = optionalCustomer.get();
//            Cart cart = customer.getCart();
//
//            if (cart != null) {
//                cartService.reduceCartQuantity(customerId, productId, quantity);
//
//                customerRepo.save(customer);
//            }
//        } else {
//            throw new NotFoundException("Customer not found with ID: " + customerId);
//        }
//    }
}

