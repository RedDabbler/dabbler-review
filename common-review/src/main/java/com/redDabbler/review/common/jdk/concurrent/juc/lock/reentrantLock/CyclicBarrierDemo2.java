package com.redDabbler.review.common.jdk.concurrent.juc.lock.reentrantLock;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * CyclicBarrier一般用于一组线程互相等待至某个状态，然后这一组线程再同时执行；
 */
public class CyclicBarrierDemo2 {

    private static int size = 5;
    static CyclicBarrier cyclicBarrier;

    public static void main(String[]args){
        //主线程中新建了5个线程，所有的这些线程都调用cb.await()等待。
        // 所有这些线程一直等待，直到cb中所有线程都达到barrier时，执行新建cb时注册的Runnable任务。
        cyclicBarrier = new CyclicBarrier(size, new Runnable() {
            @Override
            public void run() {
                System.out.println("CyclicBarrier's parties is: "+ cyclicBarrier.getParties());
            }
        });

        for (int i = 0;i<size;i++){
            new InnerThread().start();
        }

        System.out.println(Thread.currentThread().getName()+" execute");
    }

    static class InnerThread extends Thread{

        public void run(){
            try{
                System.out.println(Thread.currentThread().getName()+" wait for CyclicBarrier.");
                cyclicBarrier.await();
                System.out.println(Thread.currentThread().getName() + " continued.");
            } catch (BrokenBarrierException |InterruptedException e){
                e.printStackTrace();
            }

        }
    }
}
