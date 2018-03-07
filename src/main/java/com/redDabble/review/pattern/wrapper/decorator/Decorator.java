package com.redDabble.review.pattern.wrapper.decorator;

import com.redDabble.review.pattern.wrapper.Drink;

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
