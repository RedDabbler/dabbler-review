package com.redDabbler.review.common.pattern.strategy.discount;

public class Food {
    private double price;
    private double discount;

    Discountor<Food> discountor;



    public double getPrice(){
        return  discountor.discount(this);
    }
}
