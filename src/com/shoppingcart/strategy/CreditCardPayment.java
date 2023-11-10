package com.shoppingcart.strategy;

public class CreditCardPayment implements PaymentStrategy {
    @Override
    public void pay(double amount) {
        // Implement payment with credit card logic.
        System.out.println("Paid $" + amount + " with Credit Card.");
    }
}
