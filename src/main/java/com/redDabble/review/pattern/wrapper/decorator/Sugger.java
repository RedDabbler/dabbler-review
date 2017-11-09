package com.redDabble.review.pattern.wrapper.decorator;

import com.redDabble.review.pattern.wrapper.Drink;

/** 装饰饮料
 * Created by whh on 2017/11/9.
 */
public class Sugger extends Decorator {
    private String descption ="加了糖";
    private Double price = 5.0;

    private Drink drink;

    public Sugger(Drink drink){
        this.drink = drink;
    }

    @Override
    public Double getPrice() {
        return drink.getPrice()+this.price;
    }

    @Override
    public String getDescption() {
        return drink.getDescption()+"\n"+this.descption;
    }
}
