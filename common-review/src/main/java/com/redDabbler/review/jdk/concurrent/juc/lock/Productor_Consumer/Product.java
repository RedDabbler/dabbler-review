package com.redDabbler.review.jdk.concurrent.juc.lock.Productor_Consumer;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Product {

    private Lock lock  = new ReentrantLock();
    private int size;
    private int capacity;
    private Condition fullCondition = lock.newCondition();
    private Condition emptyCondition = lock.newCondition();

    public Product(int capacity){
        this.capacity = capacity;
    }


    public void produce(int val){

        lock.lock();
        int left = val;
        try {
            while(left>0){
                while (size>=capacity){
                    System.out.printf("Thread%s await\n",Thread.currentThread().getName());
                    fullCondition.await();
                    System.out.printf("Thread%s signal\n",Thread.currentThread().getName());
                }
                left --;
                size = size + 1;
                System.out.printf("Thread:%s,product: size=%d,capacity=%d,increase=%d\n",Thread.currentThread().getName(),size,capacity,val-left);
                emptyCondition.signalAll();

            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }

    public void consumer(int val){

        lock.lock();
        int left = val;
        try {
            while(left>0){
                while (size<=0){
                    System.out.printf("Thread%s await\n",Thread.currentThread().getName());
                    emptyCondition.await();
                    System.out.printf("Thread%s signal\n",Thread.currentThread().getName());
                }
                left --;
                size = size - 1;
                System.out.printf("Thread:%s product: size=%d,capacity=%d,decrease=%d\n",Thread.currentThread().getName(),size,capacity,val-left);
                fullCondition.signalAll();

            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }


}
