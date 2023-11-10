package com.shoppingcart.decorator;

import com.shoppingcart.adapter.Product;

public class ExtendedWarrantyDecorator extends ProductDecorator {
    public ExtendedWarrantyDecorator( Product decoratedProduct) {
        super(decoratedProduct);
    }

    @Override
    public String getName() {
        return super.getName() + " with Extended Warranty";
    }

    @Override
    public double getPrice() {
        return super.getPrice() + 9.99;
    }
}
