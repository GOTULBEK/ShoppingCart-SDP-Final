package com.shoppingcart.strategy;

public class ShoppingCartContext {
    private PaymentStrategy paymentStrategy;

    public void setPaymentStrategy(PaymentStrategy paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }

    public void performPayment(double amount) {
        paymentStrategy.pay(amount);
    }
}
