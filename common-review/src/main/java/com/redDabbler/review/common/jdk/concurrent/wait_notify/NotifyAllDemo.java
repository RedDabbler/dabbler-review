package com.redDabbler.review.common.jdk.concurrent.wait_notify;

public class NotifyAllDemo {
    private static Object obj = new Object();

    static class ThreadA extends Thread{
        public ThreadA(String t1) {
            super(t1);
        }

        public void run() {
            synchronized (obj) {
                try {
                    // 打印输出结果
                    System.out.println(Thread.currentThread().getName() + " wait");
                    // 唤醒当前的wait线程
                    obj.wait();
                    // 打印输出结果
                    System.out.println(Thread.currentThread().getName() + " continue");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }


    public static void main(String[]args){
        ThreadA thread = new ThreadA("t1");
        ThreadA thread1 = new ThreadA("t2");
        ThreadA thread2 = new ThreadA("t3");


        thread.start();
        thread1.start();
        thread2.start();
         try {
             System.out.println(Thread.currentThread().getName()+" sleep(3000)");
             Thread.sleep(3000);
         } catch (InterruptedException e) {
             e.printStackTrace();
         }

        synchronized(obj) {
     // 主线程等待唤醒。
            System.out.println(Thread.currentThread().getName()+" notifyAll()");
            obj.notifyAll();
        }

    }
}
