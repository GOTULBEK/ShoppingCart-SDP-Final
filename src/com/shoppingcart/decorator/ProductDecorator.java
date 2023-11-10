package com.shoppingcart.decorator;

import com.shoppingcart.adapter.Product;

public abstract class ProductDecorator implements Product {
    private Product decoratedProduct;

    public ProductDecorator( Product decoratedProduct) {
        this.decoratedProduct = decoratedProduct;
    }

    @Override
    public String getName() {
        return decoratedProduct.getName();
    }

    @Override
    public double getPrice() {
        return decoratedProduct.getPrice();
    }
}
