package com.shoppingcart.strategy;

public class PayPalPayment implements PaymentStrategy {
    @Override
    public void pay(double amount) {
        // Implement payment with PayPal logic.
        System.out.println("Paid $" + amount + " with PayPal.");
    }
}
