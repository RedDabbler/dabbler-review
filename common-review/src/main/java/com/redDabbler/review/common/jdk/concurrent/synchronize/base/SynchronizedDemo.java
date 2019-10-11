package com.redDabbler.review.common.jdk.concurrent.synchronize.base;

import lombok.extern.slf4j.Slf4j;

/**
 * 规则1：当多个线程访问同一个对象时，一个线程访问对象的同步方法或代码块时，其他线程也访问时会被阻塞，但不同对象不会。
 */
@Slf4j
public class SynchronizedDemo {

    private static class MyRunable implements Runnable{

        public void run(){
            //规则1：当一个线程运行的时候，另外一个线程必须等待“运行线程”释放“对象的同步锁”之后才能运行。
            synchronized (this){
                try {
                    for (int i = 0; i < 5; i++) {
                         Thread.sleep(100); // 休眠100ms
                         System.out.println(Thread.currentThread().getName() + " loop " + i);
                    }
                } catch (InterruptedException ie) {

                }
            }

        }
    }


    private static class MyThread extends Thread {

        public MyThread(String thread1) {
            super(thread1);
        }

        @Override
        public void run() {
            //规则1：当一个线程运行的时候，另外一个线程必须等待“运行线程”释放“对象的同步锁”之后才能运行。
            synchronized (this) {
                try {
                    for (int i = 0; i < 5; i++) {
                        Thread.sleep(100); // 休眠100ms
                        System.out.println(Thread.currentThread().getName() + " loop " + i);
                    }
                } catch (InterruptedException ie) {

                }
            }

        }
    }

    public void demo1(){
        Runnable demo1 = new MyRunable();

        Thread thread1 = new Thread(demo1,"thread1");
        Thread thread2 = new Thread(demo1,"thread2");
        thread1.start();
        thread2.start();
    }

    public static  void demo2(){
        MyThread myThread1 = new MyThread("thread1");
        MyThread myThread2 = new MyThread("thread2");
        myThread1.start();
        myThread2.start();
    }


    public static void main(String[]arg){
        demo2();
    }
}
