package com.alao.mystorespringbootapp.dao;


import com.alao.mystorespringbootapp.entity.Staff;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StaffRepo extends JpaRepository<Staff, Long> {


}
