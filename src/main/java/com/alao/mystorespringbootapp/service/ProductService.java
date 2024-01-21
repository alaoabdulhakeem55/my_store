package com.alao.mystorespringbootapp.service;

import com.alao.mystorespringbootapp.entity.Product;

import java.util.List;
import java.util.Optional;


public interface ProductService {

    // list of all Product
    List<Product> findAll();

    // find product by id
    Optional<Product> findById(int id);

    // update product
    Product save(Product product);

    // delete product
    void deleteById(int id);
}
