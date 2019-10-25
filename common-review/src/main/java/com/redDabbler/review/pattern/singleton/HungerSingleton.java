package com.redDabbler.review.pattern.singleton;


public class HungerSingleton {
    private static HungerSingleton singleton  = new HungerSingleton();
    public static HungerSingleton getSingleton(){
        return singleton;
    }


}
