package org.uiframework.com.domain;

import lombok.Data;

import java.util.List;

@Data
public class Cart {
    private List<Product> products;
    private float tax;

    public float getSubTotal(){
        return (float) this.products.stream().mapToDouble(Product::getPrice).sum();
    }

    public float getTotal(){
        return getSubTotal() + tax;
    }
}
