package com.redDabbler.review.common.pattern.wrapper;

/** 饮料
 */
public class Drink implements IProduct {
    private String descption;
    private Double price;
    public String getDescption() {
        return descption;
    }

    public Double getPrice() {
        return price;
    }
}
