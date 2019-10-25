package com.redDabbler.review.jdk.concurrent.basic.synchronize.lock;


public class LockDemo {
    public void syncMethod(){
        synchronized (this) {
            try {
                for (int i = 0; i < 5; i++) {
                    Thread.sleep(100); // 休眠100ms
                    System.out.println(Thread.currentThread().getName() + " syncMethod loop " + i);
                }
            } catch (InterruptedException ie) {

            }
        }
    }


    public void nonSyncMethod(){
        synchronized (this) {
            try {
                for (int i = 0; i < 5; i++) {
                    Thread.sleep(100); // 休眠100ms
                    System.out.println(Thread.currentThread().getName() + " nonsyncMethod loop " + i);
                }
            } catch (InterruptedException ie) {

            }
        }

    }

    public synchronized static void syncMethod1(){

            try {
                for (int i = 0; i < 5; i++) {
                    Thread.sleep(100); // 休眠100ms
                    System.out.println(Thread.currentThread().getName() + " static syncMethod loop " + i);
                }
            } catch (InterruptedException ie) {

            }
    }


    public synchronized static void nonSyncMethod1(){

        try {
            for (int i = 0; i < 5; i++) {
                Thread.sleep(100); // 休眠100ms
                System.out.println(Thread.currentThread().getName() + "  static nonsyncMethod loop " + i);
            }
        } catch (InterruptedException ie) {

        }

    }

    // 不能被同时访问，虽然是两个对象，但是都是LockDemo.class的锁
    public static void demo(){
        final LockDemo counter = new LockDemo();
        final LockDemo counter1 = new LockDemo();
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                counter.syncMethod1();
            }
        },"t1");
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                counter1.nonSyncMethod1();
            }
        },"t2");


        thread1.start();
        thread2.start();
    }


    // 可以被同时访问，两个对象的锁
    public static void demo1(){
        final LockDemo counter = new LockDemo();
        final LockDemo counter1 = new LockDemo();
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                counter.syncMethod();
            }
        },"t1");
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                counter1.nonSyncMethod();
            }
        },"t2");


        thread1.start();
        thread2.start();
    }


    //可以被同时访问,虽然都是同一个对象，但是syncMethod()是对象的锁，nonSyncMethod1()是LockDemo.class的锁
    public  static void demo2(){
        final LockDemo counter = new LockDemo();
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                counter.syncMethod();
            }
        },"t1");
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                counter.nonSyncMethod1();
            }
        },"t2");
        thread1.start();
        thread2.start();
    }

    //不能同时被访问，都使用LockDemo.class的锁
    public  static void demo3(){
        final LockDemo counter = new LockDemo();
        final LockDemo counter2 = new LockDemo();
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                counter.syncMethod1();
            }
        },"t1");
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                counter2.nonSyncMethod1();
            }
        },"t2");
        thread1.start();
        thread2.start();
    }


    // 不能同时被访问，都使用LockDemo类的锁
    public  static void demo4(){
        final LockDemo counter = new LockDemo();
        final LockDemo counter2 = new LockDemo();
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                LockDemo.syncMethod1();
            }
        },"t1");
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                LockDemo.nonSyncMethod1();
            }
        },"t2");
        thread1.start();
        thread2.start();
    }


    public static void main(String[]args){

        demo();
    //    demo1();
    //        demo2();
      // demo3();
     //   demo4();

    }
}
