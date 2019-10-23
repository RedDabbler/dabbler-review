package com.redDabbler.review.common.jdk.concurrent.juc.lock;

import java.util.concurrent.locks.LockSupport;

/**
 * wait,condition
 * park() 和 unpark() 的作用分别是阻塞线程和解除阻塞线程，
 */
public class LockSupportDemo {

    private static Thread mainThread;
    static class ThreadA extends Thread{

        public ThreadA(String name) {
           super(name);
        }
        public void run() {
          System.out.println(Thread.currentThread().getName()+" wakup others");
          // 唤醒“主线程”
          LockSupport.unpark(mainThread);

        }
    }

    public static void main(String[]args){
        ThreadA threadA = new ThreadA("t1");
        mainThread = Thread.currentThread();
        System.out.println(Thread.currentThread().getName()+" start ta");
        threadA.start();
        System.out.println(Thread.currentThread().getName()+" block");
        LockSupport.park(mainThread);
        System.out.println(Thread.currentThread().getName()+" continue");
    }
}
