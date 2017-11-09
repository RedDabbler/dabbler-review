package com.redDabble.review.pattern.wrapper;

/**
 * Created by whh on 2017/11/9.
 */
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
