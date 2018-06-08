package com.redDabbler.review.common.pattern.wrapper;

public class Coffee extends Drink {

    @Override
    public String getDescption() {
        return super.getDescption()+"\n"+"添加咖啡";
    }

    @Override
    public Double getPrice() {
        return super.getPrice()+20;
    }
}
