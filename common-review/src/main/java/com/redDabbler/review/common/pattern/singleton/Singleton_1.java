package com.redDabbler.review.common.pattern.singleton;

public class Singleton_1 {

    private static Singleton_1 singleton_1;

    public static Singleton_1 getSingleton_1(){
        if (singleton_1 != null){
            return singleton_1;
        }
        synchronized (singleton_1){
            singleton_1 = new Singleton_1();
            return singleton_1;
        }
    }

}
