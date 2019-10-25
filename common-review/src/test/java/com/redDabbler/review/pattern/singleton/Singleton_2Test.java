package com.redDabbler.review.pattern.singleton;

import org.junit.Test;
public class Singleton_2Test {

    @Test
    public void getInstance() {
        InnerClassSingleton singleton_2 = InnerClassSingleton.getInstance();
        System.out.println(singleton_2);
        InnerClassSingleton singleton_1 = InnerClassSingleton.getInstance();
        System.out.println(singleton_1);
    }
}