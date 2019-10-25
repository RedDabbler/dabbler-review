package com.redDabbler.review.pattern.wrapper.decorator;

import com.redDabbler.review.pattern.wrapper.Drink;

/**
 */
public class Decorator extends Drink {

    private String descption;
    private Double price;
    public String getDescption() {
        return descption;
    }

    public Double getPrice() {
        return price;
    }
}
