package com.alao.mystorespringbootapp.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@Entity
@AllArgsConstructor
public class Customer extends Base {

    private String name;
    private String email;
    private String address;

    @OneToOne(mappedBy = "customer", cascade = CascadeType.ALL)
    private Cart cart;

    @Override
    public String toString() {
        return "Customer{" +
                ", id='" + super.getId() + '\'' +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
              //               ", address='" + cart + '\'' +
                '}';
    }
}
