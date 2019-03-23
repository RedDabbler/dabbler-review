package com.redDabbler.review.common.pattern.singleton;

import org.junit.Test;
public class Singleton_2Test {

    @Test
    public void getInstance() {
        Singleton_2 singleton_2 = Singleton_2.getInstance();
        System.out.println(singleton_2);
        Singleton_2 singleton_1 = Singleton_2.getInstance();
        System.out.println(singleton_1);
    }
}