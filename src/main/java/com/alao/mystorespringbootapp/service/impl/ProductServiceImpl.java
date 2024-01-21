package com.alao.mystorespringbootapp.service.impl;

import com.alao.mystorespringbootapp.dao.ProductRepo;
import com.alao.mystorespringbootapp.entity.Product;
import com.alao.mystorespringbootapp.exceptions.NotFoundException;
import com.alao.mystorespringbootapp.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;


@Service
@AllArgsConstructor
public class ProductServiceImpl implements ProductService {
    private ProductRepo productRepo;


    @Override
    public List<Product> findAll() {
        return productRepo.findAll();
    }

    @Override
    public Optional<Product> findById(int id) {
        Optional<Product> result = productRepo.findById((long) id);

        Product product = null;

        if (result.isPresent()) {
            product = result.get();
        }
        else {

            throw new NotFoundException("Did not find product id - " + id);
        }

        return Optional.of(product);
    }

    @Transactional
    @Override
    public Product save(Product product) {
        return productRepo.save(product);
    }


    @Transactional
    @Override
    public void deleteById(int id) {
        productRepo.deleteById((long) id);

    }
}
