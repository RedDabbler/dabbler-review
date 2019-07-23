package com.redDabbler.review.common.pattern.strategy.discount;

public class HolidayDiscountor implements Discountor<Food> {

    @Override
    public double discount(Food food) {
        return food.getPrice()/2;
    }
}
