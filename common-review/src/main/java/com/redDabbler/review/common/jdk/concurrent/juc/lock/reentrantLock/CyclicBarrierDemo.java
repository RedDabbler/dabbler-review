package com.redDabbler.review.common.jdk.concurrent.juc.lock.reentrantLock;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * CyclicBarrier 它是通过ReentrantLock(独占锁)和Condition实现的。
 */
public class CyclicBarrierDemo {

    private static int size = 5;
    static CyclicBarrier cyclicBarrier;

    public static void main(String[]args){
        cyclicBarrier = new CyclicBarrier(size);
        for (int i = 0;i<size;i++){
            new InnerThread().start();
        }

    }

    /**
     * 主线程中新建了5个线程，所有的这些线程都调用cb.await()等待。
     * 所有这些线程一直等待，直到cb中所有线程都达到barrier时，这些线程才继续运行！
     */
    static class InnerThread extends Thread{

        public void run(){
            try{
                System.out.println(Thread.currentThread().getName()+" wait for CyclicBarrier.");
                cyclicBarrier.await();
                System.out.println(Thread.currentThread().getName() + " continued.");
            } catch (BrokenBarrierException|InterruptedException e){
                e.printStackTrace();
            }

        }
    }

}
