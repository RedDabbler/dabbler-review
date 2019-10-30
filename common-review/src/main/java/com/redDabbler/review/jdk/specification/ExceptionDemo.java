package com.redDabbler.review.jdk.specification;

import java.io.IOException;

interface Type1 {
    void f() throws CloneNotSupportedException;
}

interface Type2 {
    void f() throws InterruptedException;
}

interface Type3 extends Type1, Type2 {
}
public class ExceptionDemo implements Type3{

    //一个方法可以抛出的被检查异常集合是它所适用的所有类型声明要抛出的被检查异常集合的交集,而不是合集,没有抛出异常
    public void f() {
        System.out.println("Hello world");
    }
    public static void main(String[] args) {
        Type3 t3 = new ExceptionDemo();
        t3.f();
    }

    // 编译失败
    public void demo(){
//        try {
//            System.out.println("Hello world");
//        } catch(IOException e) {
//            System.out.println("I've never seen println fail!");
//        }
    }

    public void demo2(){
        try {
            // If you have nothing nice to say, say nothing
            System.out.println("Hello world");
        } catch(Exception e) {
            System.out.println("This can't happen");
        }
    }


    // 返回
    private static boolean decision() {
        try {
            return true;
        } finally {
            return false;
        }
    }
}
