package org.uiframework.com.domain;

import lombok.Data;

@Data
public class Product {
    private String name;
    private float price;

    public Product(String name, float price){
        this.name = name;
        this.price = price;
    }
}
