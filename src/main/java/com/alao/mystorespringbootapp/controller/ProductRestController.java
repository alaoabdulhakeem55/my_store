package com.alao.mystorespringbootapp.controller;

import com.alao.mystorespringbootapp.entity.Product;
import com.alao.mystorespringbootapp.exceptions.NotFoundException;
import com.alao.mystorespringbootapp.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
@RequestMapping("/api")
public class ProductRestController {

    private ProductService productService;

    @GetMapping("/products")
    public List<Product> findAll() {
        return productService.findAll();
    }

    @GetMapping("/products/{productId}")
    public Optional<Product> getProduct(@PathVariable int productId) {
        Optional<Product> product = productService.findById(productId);

        if (product.isEmpty()) {
            throw new NotFoundException("Product id not found - " + productId);
        }
        return product;
    }


    @PostMapping("/products")
    public Product addProduct(@RequestBody Product product) {

        // just in case they pass an id in JSON ... set id to 0
        // this is to force a save of new item ... instead of update

        product.setId(0L);
        return productService.save(product);
    }

    @PutMapping("/products")
    public Product updateProduct(@RequestBody Product product) {
        return productService.save(product);
    }

    @DeleteMapping("/products/{productId}")
    public void deleteProduct (@PathVariable int productId) {
        Optional<Product> tempProduct = productService.findById(productId);

        if (tempProduct.isEmpty()) {
            throw new NotFoundException("Product id not found - " + productId);
        }
        productService.deleteById(productId);
    }

}
