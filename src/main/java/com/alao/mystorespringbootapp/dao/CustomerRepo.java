package com.alao.mystorespringbootapp.dao;

import com.alao.mystorespringbootapp.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepo extends JpaRepository<Customer, Long> {
    Customer findByEmail(String email);

}