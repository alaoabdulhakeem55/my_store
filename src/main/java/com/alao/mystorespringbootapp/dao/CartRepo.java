package com.alao.mystorespringbootapp.dao;

import com.alao.mystorespringbootapp.entity.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartRepo extends JpaRepository<Cart, Long> {

    Cart findCartByCustomerId(Long customerId);

}
