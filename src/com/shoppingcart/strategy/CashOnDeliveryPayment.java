package com.shoppingcart.strategy;

public class CashOnDeliveryPayment implements PaymentStrategy {
    @Override
    public void pay(double amount) {
        // Implement cash-on-delivery payment logic.
        System.out.println("Payment of $" + amount + " will be collected on delivery.");
    }
}
