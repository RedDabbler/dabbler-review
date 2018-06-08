package com.redDabbler.review.common.pattern.wrapper.decorator;

import com.redDabbler.review.common.pattern.wrapper.Drink;

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
