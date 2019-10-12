package com.redDabbler.review.common.jdk.concurrent.basic;

import java.util.Scanner;

/**
 * Daemon的作用是为其他线程的运行提供便利服务，守护线程最典型的应用就是 GC (垃圾回收器)，它就是一个很称职的守护者。
 *
 * 当Java虚拟机启动时，通常有一个单一的非守护线程（该线程通过是通过main()方法启动）。JVM会一直运行直到下面的任意一个条件发生，JVM就会终止运行：
 * (01) 调用了exit()方法，并且exit()有权限被正常执行。
 * (02) 所有的“非守护线程”都死了(即JVM中仅仅只有“守护线程”)。
 */
public class DaemonDemo {

    static class MyThread extends Thread{
        public MyThread(String name){
            super(name);
        }
        public void run(){
            try {
                    for (int i=0; i<50; i++) {
                        Thread.sleep(3);
                        System.out.println(this.getName() +"(isDaemon="+this.isDaemon()+ ")" +", loop "+i);
                    }
                } catch (InterruptedException e) {
                }
        }
    }

    static class MyDaemon extends Thread{
        public MyDaemon(String name){
            super(name);
        }
        public void run(){
            try {
                for (int i=0; i<200; i++) {
                    Thread.sleep(3);
                    System.out.println(this.getName() +"(isDaemon="+this.isDaemon()+ ")" +", loop "+i);
                }
                //没机会执行
                System.out.println(this.getName() +"(isDaemon="+this.isDaemon()+") finish");
            } catch (InterruptedException e) {
            }
        }
    }

    public static void main(String[]args){
//        System.out.println(Thread.currentThread().getName()+"(isDaemon="+Thread.currentThread().isDaemon()+ ")");
//
//        Thread t1=new MyThread("t1");    // 新建t1
//        Thread t2=new MyDaemon("t2");    // 新建t2
//        t2.setDaemon(true);                // 设置t2为守护线程
//        t1.start();                        // 启动t1
//        t2.start();                        // 启动t2
//        //只剩t2这个守护线程的时候，JVM自动退出。

        demo2();
    }

    static class DaemonRunner implements Runnable {
        @Override
        public void run() {
            while (true) {
                for (int i = 1; i <= 100; i++) {
                    System.out.println("daemon thread:"+i);
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    public static void demo2(){
        Thread daemonThread = new Thread(new DaemonRunner());
        daemonThread.setDaemon(true);
        daemonThread.start();
        System.out.println("isDaemon? = " + daemonThread.isDaemon());
        Scanner scanner = new Scanner(System.in);
        scanner.next();
        Runtime.getRuntime().addShutdownHook(new Thread() {
            @Override
            public void run() {
                System.out.println("JVM Exit!");
            }
        });
    }


}
