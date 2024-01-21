package com.alao.mystorespringbootapp.entity;

import com.alao.mystorespringbootapp.enums.CheckoutStatus;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Checkout extends Base {

    @ManyToOne
    private Customer customer;
    @OneToMany
    private List<Order> listOfOrderId;
    private CheckoutStatus status;
    private double totalPrice;

    @Override
    public String toString() {
        return "Checkout{" +
                ", listOfOrderId=" + listOfOrderId +
                ", status=" + status +
                ", totalPrice=" + totalPrice +
                '}';
    }

}

