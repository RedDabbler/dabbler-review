package com.redDabbler.review.common.pattern.singleton;


public class Singleton {
    private static  Singleton singleton  = new Singleton();
    public static Singleton getSingleton(){
        return singleton;
    }


}
