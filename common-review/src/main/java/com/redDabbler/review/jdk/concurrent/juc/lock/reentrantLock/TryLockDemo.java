package com.redDabbler.review.jdk.concurrent.juc.lock.reentrantLock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class TryLockDemo extends Thread {
    //类的锁
    private static ReentrantLock lock = new ReentrantLock();

    public TryLockDemo(String t1) {
        super(t1);
    }


    //两个线程来争夺一把锁，获得锁的线程sleep6秒，每个线程都只尝试5秒去获得锁。
    public void run(){
        try {
            if(lock.tryLock(5, TimeUnit.SECONDS)){
                Thread.sleep(6000);
            }else{
                System.out.println(getName()+" get lock failed");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            if (lock.isHeldByCurrentThread()){
                System.out.println("lock.held "+getName());
                lock.unlock();
            }
        }
    }

    public static void main(String[]args){
        TryLockDemo tryLockDemo = new TryLockDemo("t1");
        TryLockDemo tryLockDemo1 = new TryLockDemo("t2");
        tryLockDemo.start();
        tryLockDemo1.start();
    }
}
