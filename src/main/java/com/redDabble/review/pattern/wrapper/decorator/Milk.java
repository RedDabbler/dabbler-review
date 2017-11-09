package com.redDabble.review.pattern.wrapper.decorator;

import com.redDabble.review.pattern.wrapper.Drink;

/**  装饰 饮料
 * Created by whh on 2017/11/9.
 */
public class Milk extends Decorator {
    private Drink drink;
    public Milk(){

    }
    public Milk(Drink drink){
        this.drink = drink;
    }
    @Override
    public String getDescption() {
        return drink.getDescption()+"\n"+"添加牛奶";
    }

    @Override
    public Double getPrice() {
        return drink.getPrice()+10;
    }
}
