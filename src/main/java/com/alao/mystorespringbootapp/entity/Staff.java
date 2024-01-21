package com.alao.mystorespringbootapp.entity;

import com.alao.mystorespringbootapp.enums.Gender;
import com.alao.mystorespringbootapp.enums.Roles;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@Entity
@AllArgsConstructor
public class Staff extends Base {

    private String name;
    private int age;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    @Enumerated(EnumType.STRING)
    private Roles role;


    @Override
    public String toString() {
        return "Staff{" +
                ", id='" + super.getId() + '\'' +
                "name='" + name + '\'' +
                ", age=" + age + '\'' +
                ", gender='" + getGender() + '\'' +
                ", role='" + getRole() + '\'' +
                '}';
    }
}
