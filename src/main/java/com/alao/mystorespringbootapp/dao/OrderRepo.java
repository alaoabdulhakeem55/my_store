package com.alao.mystorespringbootapp.dao;

import com.alao.mystorespringbootapp.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepo extends JpaRepository<Order, Long> {
    Order getById(Long userId);
}
