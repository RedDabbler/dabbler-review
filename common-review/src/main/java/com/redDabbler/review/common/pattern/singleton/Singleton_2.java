package com.redDabbler.review.common.pattern.singleton;

public class Singleton_2 {
    private static Singleton_2 singleton_2;

    private static Context context = new Context();

    private Singleton_2(){
    }

    public static Singleton_2 getInstance(){
        return singleton_2;
    }

    private static class Context{
        private Context(){
            singleton_2 = new Singleton_2();
        }
    }




}
