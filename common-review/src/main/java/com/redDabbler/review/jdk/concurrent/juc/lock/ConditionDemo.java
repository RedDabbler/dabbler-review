package com.redDabbler.review.jdk.concurrent.juc.lock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 可对照WaitDemo
 * Condition是需要与"互斥锁"/"共享锁"捆绑使用的。
 * Condition 更强大的地方在于：
 * 能够更加精细的控制多线程的休眠与唤醒。
 * 对于同一个锁，我们可以创建多个Condition，在不同的情况下使用不同的Condition。
 * 例如，假如多线程读/写同一个缓冲区：
 * 当向缓冲区中写入数据之后，唤醒"读线程"；
 * 当从缓冲区读出数据之后，唤醒"写线程"；
 * 并且当缓冲区满的时候，"写线程"需要等待；
 * 当缓冲区为空时，"读线程"需要等待。
 * 如果采用Object类中的wait(), notify(), notifyAll()实现该缓冲区，
 * 当向缓冲区写入数据之后需要唤醒"读线程"时，不可能通过notify()或notifyAll()明确的指定唤醒"读线程"，
 * 而只能通过notifyAll唤醒所有线程(但是notifyAll无法区分唤醒的线程是读线程，还是写线程)。
 *
 * 但是，通过Condition，就能明确的指定唤醒读线程。
 */
public class ConditionDemo {
    private static Lock lock = new ReentrantLock();
    private static Condition condition = lock.newCondition();
    static class ThreadA extends Thread{
        public ThreadA(String name){
            super(name);
        }

        public void run(){
            lock.lock();
            try{
                System.out.println(Thread.currentThread().getName() +" wakeup others");
                condition.signal();
            }finally {
                lock.unlock();
            }

        }
    }

    public static void main(String[]args){
        ThreadA threadA = new ThreadA("t1");
        lock.lock();
        try {
            System.out.println(Thread.currentThread().getName() + " start ");
            threadA.start();

            System.out.println(Thread.currentThread().getName() + " block");

            condition.await();
            System.out.println(Thread.currentThread().getName()+" continue");
        }catch(InterruptedException e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }

    }
}
