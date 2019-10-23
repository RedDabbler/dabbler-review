package com.redDabbler.review.common.jdk.concurrent.juc.threadPool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Executors
 *
 * Executors是个静态工厂类
 */
public class ExecutorServiceDemo {


    public static void main(String[]args){
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        executorService.execute(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName()+ " is running.");
            }
        });

        executorService.shutdown();
    }
}
