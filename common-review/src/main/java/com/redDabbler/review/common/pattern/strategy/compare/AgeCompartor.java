package com.redDabbler.review.common.pattern.strategy.compare;

public class AgeCompartor implements Compartor<Cat> {
    @Override
    public int compare(Cat t1, Cat t2) {
        return t1.getAge() - t1.getAge();
    }
}
