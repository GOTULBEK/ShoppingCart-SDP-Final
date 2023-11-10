package com.shoppingcart;

import com.shoppingcart.adapter.Product;

public class ConcreteProduct implements Product {
    private String name;
    private double price;

    public ConcreteProduct(String name, double price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public double getPrice() {
        return price;
    }
}
