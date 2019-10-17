package com.redDabbler.review.common.jdk.concurrent.juc.lock.reentrantLock;

import java.util.concurrent.locks.ReentrantLock;

/**
 * 实现了Lock接口
 * 相比于synchronized，
 * ReentrantLock在功能上更加丰富，它具有可重入、可中断、可限时、公平锁等特点。
 *
 * 一般意义上的锁是不公平的，不一定先来的线程能先得到锁，后来的线程就后得到锁。不公平的锁可能会产生饥饿现象。
 * 虽然公平锁不会产生饥饿现象，但是公平锁的性能会比非公平锁差很多。
 *
 * ReentrantLock是独占锁。所谓独占锁，是指只能被独自占领，即同一个时间点只能被一个线程锁获取到的锁。
 */
public class ReentrantLockDemo extends Thread {

    // 类的锁
    private static ReentrantLock lock = new ReentrantLock();
    private static int i =0;

    public void run(){
        for(int j=0;j<1000;j++){
            lock.lock();
            // 可重入
            lock.lock();
            try{
                System.out.println(this.getName() + " " + i);
                i++;
            }finally {
                lock.unlock();
                // 2次重入要释放2次哦
          //      lock.unlock();
            }

        }
    }

    public static void main(String[]args)throws InterruptedException{


        ReentrantLockDemo reentrantLockDemo = new ReentrantLockDemo();
        ReentrantLockDemo reentrantLockDemo1 = new ReentrantLockDemo();
        reentrantLockDemo.start();
        reentrantLockDemo1.start();
        reentrantLockDemo.join();
        reentrantLockDemo1.join();
        System.out.println("i="+i);

    }

}
