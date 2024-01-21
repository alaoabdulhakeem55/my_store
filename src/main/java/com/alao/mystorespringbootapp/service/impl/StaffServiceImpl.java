package com.alao.mystorespringbootapp.service.impl;

import com.alao.mystorespringbootapp.dao.StaffRepo;
import com.alao.mystorespringbootapp.entity.Staff;
import com.alao.mystorespringbootapp.enums.Gender;
import com.alao.mystorespringbootapp.enums.Roles;
import com.alao.mystorespringbootapp.exceptions.AppException;
import com.alao.mystorespringbootapp.exceptions.NotFoundException;
import com.alao.mystorespringbootapp.service.StaffService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Objects;
import java.util.Optional;

@Service
@AllArgsConstructor
public class StaffServiceImpl implements StaffService {
    private StaffRepo staffRepo;

    @Transactional
    @Override
    public Staff hire(String name, int age, Gender gender, Roles role) {
        if ((role == Roles.CASHIER && age >= 20 && age <= 40 && (gender == Gender.MALE || gender == Gender.FEMALE)) ||
                (role == Roles.MANAGER && age >= 35 && age <= 50 && (gender == Gender.MALE || gender == Gender.FEMALE))) {
            Staff newStaff = new Staff(name, age, gender, role);
            return staffRepo.save(newStaff);
        }
        throw new AppException("Not qualified");
    }

    @Transactional
    @Override
    public Staff fire(Long id) {
        Staff staff = staffRepo.getById(id);
        if(Objects.equals(staff.getRole(), staff.getId())) {
            return staff;
        }
        staffRepo.deleteById(staff.getId());
        return staff;
    }

    @Override
    public Object findAll() {
        return staffRepo.findAll();
    }

    @Override
    public Optional<Staff> findById(Long id) {
        Optional<Staff> result = staffRepo.findById(id);

        Staff staff = null;

        if (result.isPresent()) {
            staff = result.get();
        }
        else {

            throw new NotFoundException("Did not find staff id - " + id);
        }

        return Optional.of(staff);
    }

    @Override
    public Staff save(Staff staff) {
        return staffRepo.save(staff);
    }
}

