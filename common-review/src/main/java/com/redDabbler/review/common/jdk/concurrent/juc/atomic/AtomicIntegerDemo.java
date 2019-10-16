package com.redDabbler.review.common.jdk.concurrent.juc.atomic;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicIntegerDemo {

    public static void main(String[]args){
        AtomicInteger ai = new AtomicInteger();
        ai.set(123);
        System.out.println("get()=="+ai.get());
        System.out.println("getAndAdd()=="+ai.getAndAdd(5)+" ai=="+ai.get());
        System.out.println("addAndGet()=="+ai.addAndGet(5));
        System.out.println("compareAndSet()=="+ai.compareAndSet(133,6)+" ai=="+ai.get());
        System.out.println("decrementAndGet()=="+ai.decrementAndGet());
        System.out.println("incrementAndGet()=="+ai.incrementAndGet());
        System.out.println("getAndDecrement()=="+ai.getAndDecrement());
        ai.lazySet(23);
        System.out.println("get()=="+ai.toString());
        System.out.println("weakCompareAndSet=="+ai.weakCompareAndSet(23,20)+" ai=="+ai.get());
    }
}
