package com.alao.mystorespringbootapp.controller;

import com.alao.mystorespringbootapp.entity.Staff;
import com.alao.mystorespringbootapp.enums.Gender;
import com.alao.mystorespringbootapp.enums.Roles;
import com.alao.mystorespringbootapp.exceptions.AppException;
import com.alao.mystorespringbootapp.exceptions.NotFoundException;
import com.alao.mystorespringbootapp.service.StaffService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@AllArgsConstructor
@RequestMapping("/api")
public class StaffRestController {

    private StaffService staffService;

    @PostMapping("/staff")
    public Staff hire(@RequestBody Staff staff) {

        String name = staff.getName();
        int age = staff.getAge();
        Gender gender = staff.getGender();
        Roles role = staff.getRole();

        // just in case they pass an id in JSON ... set id to 0
        // this is to force a save of new item ... instead of update

        try {
            staff.setId(0L); // To force a save of new item ... instead of update
            return staffService.hire(staff.getName(), staff.getAge(), staff.getGender(), staff.getRole());
        } catch (AppException e) {
            throw new NotFoundException("Not qualified");
        }
    }


    @PutMapping("/staff")
    public Staff updateStaff(@RequestBody Staff staff) {
        Staff dbStaff = staffService.save(staff);
        return dbStaff;
    }

    @DeleteMapping("/staff/{staffId}")
    public Staff fire (@PathVariable int staffId) {
        Optional<Staff> tempStaff = staffService.findById((long) staffId);

        if (tempStaff.isEmpty()) {
            throw new NotFoundException("Staff id not found - " + staffId);
        }
        Staff staff = staffService.fire((long) staffId);
        return staff;
    }

    @GetMapping("/staff")
    public Object findAll() {
        return staffService.findAll();
    }

    @GetMapping("/staff/{staffId}")
    public Optional<Staff> getStaff(@PathVariable int staffId) {

        try {
            return staffService.findById((long) staffId);
        } catch (NotFoundException e) {
            throw new NotFoundException("Staff " +  staffId + " not found");
        }
    }
}
