package com.redDabbler.review.common.jdk.concurrent.juc.threadPool.rejectPolicy;

public class MyRunnable implements Runnable{
    private String name;
    public MyRunnable(String name) {
        this.name = name;
    }
    public void run(){

        try {
            System.out.println(this.name+" thread is running");
            Thread.sleep(2000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }

    }
}
