package com.alao.mystorespringbootapp.entity;

import com.alao.mystorespringbootapp.enums.OrderStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
@AllArgsConstructor
public class Order extends Base {
    @ManyToOne
    private Customer customer;
    @OneToMany
    private List<Product> product;
    private int quantity;
    private double price;
    private OrderStatus status;


    @Override
    public String toString() {
        return "Order{" +
                ", quantity=" + quantity +
                ", cost=" + price +
                ", orderId=" + super.getId() +
                ", status=" + status +
                '}';
    }
}

