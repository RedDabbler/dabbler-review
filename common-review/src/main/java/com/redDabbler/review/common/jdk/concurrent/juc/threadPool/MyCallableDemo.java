package com.redDabbler.review.common.jdk.concurrent.juc.threadPool;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class MyCallableDemo {


   static class MyCallable implements Callable{

        @Override
        public Integer call() throws Exception {
            int sum = 0;
            for(int i=0;i<100;i++){
                sum += i;
            }
            return Integer.valueOf(sum);
        }
    }

    public static void main(String[]args)throws Exception{
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        Callable callable = new MyCallable();
        Future future = executorService.submit(callable);
        System.out.println(future.get());
        executorService.shutdown();
    }
}
