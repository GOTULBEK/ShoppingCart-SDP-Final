package com.shoppingcart.observer;

public interface CartSubject {
    void addObserver(CartObserver observer);
    void removeObserver(CartObserver observer);
    void notifyObservers();
}
