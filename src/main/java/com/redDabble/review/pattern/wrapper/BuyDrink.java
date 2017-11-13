package com.redDabble.review.pattern.wrapper;

import com.redDabble.review.pattern.wrapper.decorator.Milk;
import com.redDabble.review.pattern.wrapper.decorator.Sugger;

/**
 * Created by whh on 2017/11/9.
 */
public class BuyDrink {

    //买了一杯加糖加牛奶的水，也可以是各种组合 最后能得到混合的口味
    public static void main(String[] args) {
        Drink drink = new Water();
        drink = new Milk(drink);
        drink = new Sugger(drink);
        System.out.print(drink.getDescption());
        System.out.print("\n一共："+drink.getPrice());
    }
}
