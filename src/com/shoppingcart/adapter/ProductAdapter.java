package com.shoppingcart.adapter;

public class ProductAdapter implements Product {
    private ExternalProduct externalProduct;

    public ProductAdapter(ExternalProduct externalProduct) {
        this.externalProduct = externalProduct;
    }

    @Override
    public String getName() {
        return externalProduct.getTitle();
    }

    @Override
    public double getPrice() {
        return externalProduct.getCost();
    }
}
