package com.redDabbler.review.common.jdk.concurrent.synchronise;

import lombok.extern.slf4j.Slf4j;



@Slf4j
public class Counter implements Runnable {
    int count ;
    @Override
    public synchronized  void run() {
        for (int i=0;i<10;i++){
            count ++;
            log.info("{} count:{}",Thread.currentThread().getName(),count);
        }
    }

    public static void main(String[]args){
        Counter counter = new Counter();
        Thread thread = new Thread(counter);
        Thread thread1 = new Thread(counter);
        thread.start();
        thread1.start();
    }

}
