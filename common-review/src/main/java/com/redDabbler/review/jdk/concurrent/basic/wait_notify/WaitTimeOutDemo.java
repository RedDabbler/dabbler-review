package com.redDabbler.review.jdk.concurrent.basic.wait_notify;

public class WaitTimeOutDemo {

    static class ThreadA extends Thread{
        public void run(){
            System.out.println(Thread.currentThread().getName()+" run");
            while(true);
        }
    }

    public static void main(String[]args)throws Exception{
        ThreadA threadA = new ThreadA();
        synchronized(threadA){
            System.out.println(Thread.currentThread().getName()+" start");
            threadA.start();
            System.out.println(Thread.currentThread().getName() + " call wait ");
            threadA.wait(3000);


            System.out.println(Thread.currentThread().getName() + " continue ");

        }
    }
}
