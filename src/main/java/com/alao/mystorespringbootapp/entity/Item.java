package com.alao.mystorespringbootapp.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@NoArgsConstructor
public class Item extends Base {

    @Column(name="productName")
    private String productName;

    @Column(name="productId")
    private String productId;

    @Column(name="quantity")
    private int quantity;

    @Column(name="unitPrice")
    private double unitPrice;

    @Column(name="totalPrice")
    private double totalPrice;

//    @ManyToOne
//    @JoinColumn(name = "cart_id")
//    private Cart cart;


    @Override
    public String toString() {
        return "Item{" +
                "productName='" + productName + '\'' +
                ", productId='" + productId + '\'' +
                ", quantity=" + quantity +
                ", unitPrice=" + unitPrice +
                ", totalPrice=" + totalPrice +
                '}';
    }
}

