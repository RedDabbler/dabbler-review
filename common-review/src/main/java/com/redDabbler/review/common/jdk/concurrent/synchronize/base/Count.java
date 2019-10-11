package com.redDabbler.review.common.jdk.concurrent.synchronize.base;

/**
 * 规则3：当多个线程同时访问1个对象时，一个线程访问对象的一个同步方法，其他线程访问对象的同步方法会被阻塞
 */
public class Count {
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
        synchronized (this) {
            try {
                for (int i = 0; i < 5; i++) {
                    Thread.sleep(100); // 休眠100ms
                    System.out.println(Thread.currentThread().getName() + " nonsyncMethod loop " + i);
                }
            } catch (InterruptedException ie) {

            }
        }

    }

    public static void main(String[]args){
        final Count counter = new Count();
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
