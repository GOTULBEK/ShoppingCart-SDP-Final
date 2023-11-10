package com.shoppingcart;

import com.shoppingcart.adapter.Product;

public class ProductFactory {
    public static Product createProduct( String name, double price) {
        return new ConcreteProduct(name, price);
    }
}
