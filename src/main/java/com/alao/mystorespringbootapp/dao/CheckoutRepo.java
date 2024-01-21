package com.alao.mystorespringbootapp.dao;

import com.alao.mystorespringbootapp.entity.Checkout;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CheckoutRepo extends JpaRepository<Checkout, Long> {

}
