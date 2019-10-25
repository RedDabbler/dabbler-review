package com.redDabbler.review.pattern.wrapper;

/**
 */
public class Water extends Drink {
    private String descption="买了水";
    private Double price =20.0;

    @Override
    public String getDescption() {
        return descption;
    }

    @Override
    public Double getPrice() {
        return price;
    }
}
