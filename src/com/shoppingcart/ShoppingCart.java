package com.shoppingcart;

import com.shoppingcart.adapter.Product;
import com.shoppingcart.observer.CartObserver;
import com.shoppingcart.observer.CartSubject;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart implements CartSubject {
    private static ShoppingCart instance;
    private List<Product> items;
    private List<CartObserver> observers;

    private ShoppingCart() {
        items = new ArrayList<>();
        observers = new ArrayList<>();
    }

    public static ShoppingCart getInstance() {
        if (instance == null) {
            instance = new ShoppingCart();
        }
        return instance;
    }

    public void addProduct(Product product) {
        items.add(product);
        notifyObservers();
    }

    public void removeProduct(Product product) {
        items.remove(product);
        notifyObservers();
    }

    public double getTotal() {
        double total = 0;
        for (Product item : items) {
            total += item.getPrice();
        }
        return total;
    }

    @Override
    public void addObserver(CartObserver observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(CartObserver observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (CartObserver observer : observers) {
            observer.update();
        }
    }

    public List<Product> getProducts() {
        return items;
    }
}
