package com.redDabbler.review.common.pattern.singleton;

public class LazySingleton {

    private static LazySingleton singleton;

    public static LazySingleton getSingleton(){
        if (singleton != null){
            return singleton;
        }
        synchronized (singleton){
            singleton = new LazySingleton();
            return singleton;
        }
    }

}
