package com.redDabbler.review.pattern.strategy.discount;

public class HolidayDiscountor implements Discountor<Food> {

    @Override
    public double discount(Food food) {
        return food.getPrice()/2;
    }
}
