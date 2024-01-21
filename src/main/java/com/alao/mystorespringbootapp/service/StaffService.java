package com.alao.mystorespringbootapp.service;

import com.alao.mystorespringbootapp.entity.Staff;
import com.alao.mystorespringbootapp.enums.Gender;
import com.alao.mystorespringbootapp.enums.Roles;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface StaffService {
    Staff hire(String name, int age, Gender gender, Roles role);
    Staff fire(Long id);
    Object findAll();
    Optional<Staff> findById(Long id);
    Staff save(Staff staff);
}
