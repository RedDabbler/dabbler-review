package com.redDabbler.review.common.jdk.concurrent.basic.wait_notify;

public class WaitDemo {
    static class ThreadA extends Thread{
        public ThreadA(String name){
            super(name);
        }

        public void run(){
            System.out.println(Thread.currentThread().getName()+" call notify()");
            notify();
        }
    }

    public static void main(String[]args)throws Exception{

        ThreadA threadA = new ThreadA("thread1");
        synchronized (threadA){
            System.out.println(Thread.currentThread().getName()+" start");
            threadA.start();

            System.out.println(Thread.currentThread().getName()+" wait");
            threadA.wait();
            System.out.println(Thread.currentThread().getName()+" continue");

        }


    }
}
