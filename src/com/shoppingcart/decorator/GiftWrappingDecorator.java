package com.shoppingcart.decorator;

import com.shoppingcart.adapter.Product;

public class GiftWrappingDecorator extends ProductDecorator {
    public GiftWrappingDecorator( Product decoratedProduct) {
        super(decoratedProduct);
    }

    @Override
    public String getName() {
        return super.getName() + " with Gift Wrapping";
    }

    @Override
    public double getPrice() {
        return super.getPrice() + 2.99;
    }
}
