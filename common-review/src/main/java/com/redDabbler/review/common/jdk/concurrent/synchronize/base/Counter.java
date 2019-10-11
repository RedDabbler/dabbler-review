package com.redDabbler.review.common.jdk.concurrent.synchronize.base;

import lombok.extern.slf4j.Slf4j;


/**
 * 规则2：当多个线程同时访问一个对象时，一个线程访问对象的同步方法是，其他线程可以访问线程的非同步方法
 */
@Slf4j
public class Counter {

    public void syncMethod(){
        synchronized (this) {
            try {
                for (int i = 0; i < 5; i++) {
                    Thread.sleep(100); // 休眠100ms
                    System.out.println(Thread.currentThread().getName() + " syncMethod loop " + i);
                }
            } catch (InterruptedException ie) {

            }
        }
    }

    public void nonSyncMethod(){
        try {
            for (int i = 0; i < 5; i++) {
                Thread.sleep(100); // 休眠100ms
                System.out.println(Thread.currentThread().getName() + " nonsyncMethod loop " + i);
            }
        } catch (InterruptedException ie) {

        }

    }


    public static void main(String[]args){

        final Counter counter = new Counter();
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                counter.syncMethod();
            }
        },"t1");
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                counter.nonSyncMethod();
            }
        },"t2");

        thread1.start();
        thread2.start();
    }

}
