package com.shoppingcart.adapter;

import com.shoppingcart.ConcreteProduct;
import java.util.Arrays;
import java.util.List;

public interface Product {
    static List<Product> getProducts() {
        return Arrays.asList(
                new ConcreteProduct("Apples", 2.99),
                new ConcreteProduct("Milk", 1.99),
                new ConcreteProduct("Bread", 3.49),
                new ConcreteProduct("Eggs", 2.49),
                new ConcreteProduct("Bananas", 1.79),
                new ConcreteProduct("Cheese", 4.99),
                new ConcreteProduct("Tomatoes", 2.29),
                new ConcreteProduct("Chicken", 6.99),
                new ConcreteProduct("Potatoes", 1.99),
                new ConcreteProduct("Onions", 1.49)
        );
    }

    String getName();
    double getPrice();
}