package com.redDabbler.review.pattern.strategy.discount;

public interface Discountor<T> {
    public double discount(T t);
}
