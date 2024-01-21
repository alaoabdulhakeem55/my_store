package com.alao.mystorespringbootapp.service.impl;

import com.alao.mystorespringbootapp.dao.CartRepo;
import com.alao.mystorespringbootapp.dao.CustomerRepo;
import com.alao.mystorespringbootapp.dao.ProductRepo;
import com.alao.mystorespringbootapp.entity.Cart;
import com.alao.mystorespringbootapp.entity.Customer;
import com.alao.mystorespringbootapp.entity.Item;
import com.alao.mystorespringbootapp.entity.Product;
import com.alao.mystorespringbootapp.exceptions.AppException;
import com.alao.mystorespringbootapp.service.CartService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
@AllArgsConstructor
public class CartServiceImpl implements CartService {
    private final CartRepo cartRepo;
    private final ProductRepo productRepo;
    private final CustomerRepo customerRepo;



//    @Transactional
//    @Override
//    public Cart addToCart(Long customerId, Long productId, int quantity) {
//        Cart cart = cartRepo.findCartByCustomerId(customerId);
////        if (cart == null) {
////            Cart newCart = new Cart(new Customer(), new ArrayList<>());
////            cart = cartRepo.save(newCart);
////        }
//
//        Product product = productRepo.findById(productId).orElseThrow(()->new AppException("Product not found with ID: " + productId));
//
//        if (quantity > product.getQuantity()) {
//            throw new AppException("Product out of stock. Available quantity: " + product.getQuantity());
//        }
//
//        List<Item> itemList = new ArrayList<>(cart.getItemList());
//        itemList = handleItem(itemList, product, quantity);
//        cart.setItemList(itemList);
//
//        return cartRepo.save(cart);
//
//    }

    public List<Item> handleItem(List<Item> itemList, Product product, int quantity) {
        for (Item item : itemList) {
            if (String.valueOf(item.getProductId()).equals(String.valueOf(product.getId()))) {
                int currentQuantity = item.getQuantity();
                int newQuantity = currentQuantity + quantity;
                if (newQuantity > product.getQuantity()) {
                    throw new AppException("Product out of stock. Available quantity: " + product.getQuantity());
                }

                item.setQuantity(newQuantity);
                item.setUnitPrice(product.getPrice());
                return itemList;
            }
        }

        Item newItem = new Item();
        itemList.add(newItem);
        return itemList;
    }

//    @Transactional
//    @Override
//    public Cart reduceCartQuantity(Long customerId, Long productId, int quantity) {
//        Cart cart = cartRepo.findCartByCustomerId(customerId);
//        if (cart == null) {
//            throw new AppException("Cart not found for user ID: " + customerId);
//        }
//
//        List<Item> itemList = new ArrayList<>(cart.getItemList());
//        Product product = productRepo.getById(productId);
//        if (product == null) {
//            throw new AppException("Product not found with ID: " + productId);
//        }
//
//        for (int i = 0; i < itemList.size(); i++) {
//            Item item = itemList.get(i);
//            if (String.valueOf(item.getProductId()).equals(String.valueOf(product.getId()))) {
//                int newQuantity = item.getQuantity() - quantity;
//                if (newQuantity < 0) {
//                    throw new AppException("Invalid quantity to reduce. Item quantity: " + item.getQuantity());
//                }
//                item.setQuantity(newQuantity);
//                if (newQuantity == 0) {
//                    itemList.remove(i);
//                }
//                return cartRepo.save(cart);
//            }
//        }
//
//        throw new AppException("Product not found in the cart for ID: " + productId);
//    }

    @Override
    public Object findAll() {
        return cartRepo.findAll();
    }

    @Override
    public Cart findByUserId(Long customerId) {
        return cartRepo.findCartByCustomerId(customerId);
    }

    @Override
    public Cart save(Cart cart) {
        return cartRepo.save(cart);
    }

    @Override
    public void addProductToCart(Long productId, Long customerId) {
        Product product = productRepo.findById(productId).orElseThrow(()-> new AppException("Product not found with ID " + productId));
        Customer customer = customerRepo.findById(customerId).orElseThrow(()-> new AppException("Customer not found with ID " + customerId));
        Cart cart = customer.getCart();

        if(cart == null){
            cart = new Cart();
            cart.setCustomer(customer);
        }
        cart.addProductToCart(product);
        cartRepo.save(cart);
    }
}

