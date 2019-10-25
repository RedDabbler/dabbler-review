package com.redDabbler.review.jdk.concurrent.juc.lock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

// 可以明确指定唤醒的线程
public class ConditionDemo2 {

    private static BoundBuffer boundBuffer = new BoundBuffer();

    static class BoundBuffer{
        private static Lock lock = new ReentrantLock();
        private static Condition fullCondition = lock.newCondition();
        private static Condition emptyCondition = lock.newCondition();
        Object[] items = new Object[5];
        int putptr, takeptr, count;
        public void put(Object x){
            lock.lock();
            try{
                while (count == items.length){
                    fullCondition.await();
                }
                items[putptr] = x;
                if (++putptr == items.length){
                    putptr = 0;
                }
                count++;
                emptyCondition.signal();
                // 打印写入的数据
                System.out.println(Thread.currentThread().getName() + " put  "+ (Integer)x);
            }catch (InterruptedException e){

            }finally {
                lock.unlock();
            }

        }


        public Object  take(){
            lock.lock();
            try{
                while(count == 0){
                    emptyCondition.await();
                }

                Object x = items[takeptr];
                count --;
                if (++takeptr == items.length){
                    takeptr = 0;
                }
                fullCondition.signal();
                // 打印取出的数据
                System.out.println(Thread.currentThread().getName() + " take "+ x);
                return x;
            }catch (InterruptedException e){
                e.printStackTrace();
                return null;
            }finally {
                lock.unlock();
            }
        }

    }
    static class PutThread extends Thread{
        private int num;
        public PutThread(String name, int num) {
            super(name);
            this.num = num;
        }

        public void run(){
            boundBuffer.put((Integer)num);
        }


    }


    static class TakeThread extends Thread {
        public TakeThread(String name) {
            super(name);
        }
        public void run() {
            try {
                Thread.sleep(10);                    // 线程休眠1ms
                Integer num = (Integer)boundBuffer.take();    // 从BoundedBuffer中取出数据
            } catch (InterruptedException e) {
            }
        }
    }

    public static  void main(String[]args){
        // 启动10个“写线程”，向BoundedBuffer中不断的写数据(写入0-9)；
        // 启动10个“读线程”，从BoundedBuffer中不断的读数据。
        for (int i=0; i<10; i++) {
            new PutThread("p"+i, i).start();
            new TakeThread("t"+i).start();
        }
    }
}
