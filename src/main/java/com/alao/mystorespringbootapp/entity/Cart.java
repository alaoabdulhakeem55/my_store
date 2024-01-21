package com.alao.mystorespringbootapp.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name="carts")
@NoArgsConstructor
@AllArgsConstructor
public class Cart extends Base {

    @OneToOne
    @JoinColumn(name="customer_Id")
    private Customer customer ;
    @OneToMany
    private List<Product> itemList = new ArrayList<>();

    public void addProductToCart(Product product){
        itemList.add(product);
    }

//    @Override
//    public String toString() {
//        return "Cart{" +
//                ", itemList=" + itemList +
//                '}';
//    }
}
