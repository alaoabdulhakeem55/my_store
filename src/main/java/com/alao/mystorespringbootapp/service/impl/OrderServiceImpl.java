//package com.alao.mystorespringbootapp.service.impl;
//
//import com.alao.mystorespringbootapp.dao.OrderRepo;
//import com.alao.mystorespringbootapp.dao.ProductRepo;
//import com.alao.mystorespringbootapp.entity.Order;
//import com.alao.mystorespringbootapp.entity.Product;
//import com.alao.mystorespringbootapp.enums.OrderStatus;
//import com.alao.mystorespringbootapp.service.OrderService;
//import lombok.AllArgsConstructor;
//import org.springframework.stereotype.Service;
//
//@Service
//@AllArgsConstructor
//public class OrderServiceImpl implements OrderService {
//    private final OrderRepo orderRepo;
//    private final ProductRepo productRepo;
//
//    @Override
//    public Order cancelOrder(String orderId) {
//        Order order = orderRepo.getById(Long.valueOf(orderId));
//        if (order.getStatus() == OrderStatus.PENDING || order.getStatus() == OrderStatus.CHECKOUT) {
//            order.setStatus(OrderStatus.UNDELIVERED);
//            orderRepo.save(order);
//            String productId = String.valueOf(order.getId());
//            Product product = productRepo.getById(Long.valueOf(productId));
//            int newQuantity = order.getQuantity() + product.getQuantity();
//            product.setQuantity(newQuantity);
//        } else {
//            System.out.println("Unable to cancel order.");
//        }
//        return order;
//    }
//
//    @Override
//    public Order retrieveOrder(String orderId) {
//        return orderRepo.getById(Long.valueOf(orderId));
//    }
//
//    @Override
//    public Object retrieveUserOrder(String userId) {
//        return orderRepo.getById(Long.valueOf(userId));
//
//    }
//}
//
