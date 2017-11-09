package com.redDabble.review.pattern.wrapper;

/** 饮料
 * Created by whh on 2017/11/9.
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
