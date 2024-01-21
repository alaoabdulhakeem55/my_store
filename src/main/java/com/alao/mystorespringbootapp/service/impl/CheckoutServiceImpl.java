//package com.alao.mystorespringbootapp.service.impl;
//
//import com.alao.mystorespringbootapp.dao.CheckoutRepo;
//import com.alao.mystorespringbootapp.dao.OrderRepo;
//import com.alao.mystorespringbootapp.dao.ProductRepo;
//import com.alao.mystorespringbootapp.entity.*;
//import com.alao.mystorespringbootapp.enums.CheckoutStatus;
//import com.alao.mystorespringbootapp.enums.OrderStatus;
//import com.alao.mystorespringbootapp.exceptions.AppException;
//import com.alao.mystorespringbootapp.service.CheckoutService;
//import lombok.AllArgsConstructor;
//import org.springframework.stereotype.Service;
//
//@Service
//@AllArgsConstructor
//public class CheckoutServiceImpl implements CheckoutService {
//    private final CheckoutRepo checkoutRepo;
//    private final ProductRepo productRepo;
//    private final OrderRepo orderRepo;
//
//    @Override
//    public Checkout initiateCheckout(Cart cart) {
//
//        Checkout checkout = new Checkout();
//        checkout.setId(cart.getId());
//
//        double totalPrice = 0.0;
//
//        for (Item item : cart.getItemList()) {
//            Product product = productRepo.getById(item.getId());
//            if (product == null) {
//                throw new AppException("Product not found: " + item.getProductId());
//            }
//
//            if (item.getQuantity() > product.getQuantity()) {
//                throw new AppException("Product out of stock: " + product.getName());
//            }
//
//            int newQuantity = product.getQuantity() - item.getQuantity();
//            product.setQuantity(newQuantity);
//            productRepo.save(product);
//
//            double cost = product.getPrice() * item.getQuantity();
//            totalPrice += cost;
//
//            Order order = new Order();
//            order = orderRepo.save(order);
//            checkout.getListOfOrderId().add(order);
//        }
//
//        checkout.setTotalPrice(totalPrice);
//        checkout = checkoutRepo.save(checkout);
//        return checkout;
//    }
//
//    public Checkout finaliseCheckout(Checkout checkout) {
//        if(checkout.getTotalPrice() < 100) {
//            throw new AppException("cannot make payment for checkout less than 100.");
//        }
//        for(Order id : checkout.getListOfOrderId()) {
//            Order order = orderRepo.getById(id.getId());
//            order.setStatus(OrderStatus.CHECKOUT);
//            orderRepo.save(order);
//        }
//        checkout.setStatus(CheckoutStatus.PAID);
//        return checkout;
//    }
//}