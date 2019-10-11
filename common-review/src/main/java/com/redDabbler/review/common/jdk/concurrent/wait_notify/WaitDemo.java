package com.redDabbler.review.common.jdk.concurrent.wait_notify;

public class WaitDemo {
    class ThreadA extends Thread{
        public ThreadA(String name){
            super(name);
        }

        public void run(){
            System.out.println(Thread.currentThread().getName()+" call notify()");
            notify();

        }
    }
}
