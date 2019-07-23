package com.redDabbler.review.common.pattern.strategy.discount;

public interface Discountor<T> {
    public double discount(T t);
}
