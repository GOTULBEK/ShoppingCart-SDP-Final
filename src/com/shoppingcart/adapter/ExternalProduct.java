package com.shoppingcart.adapter;

public class ExternalProduct {
    private String title;
    private double cost;

    public ExternalProduct(String title, double cost) {
        this.title = title;
        this.cost = cost;
    }

    public String getTitle() {
        return title;
    }

    public double getCost() {
        return cost;
    }
}
