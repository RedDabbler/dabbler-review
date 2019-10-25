package com.redDabbler.review.jdk.concurrent.basic;

/**
 * 线程中断自己是被允许的
 * 其它线程调用本线程的interrupt()方法时，会通过checkAccess()检查权限。这有可能抛出SecurityException异常。
 *
 * wait(), wait(long)或wait(long, int),join(), join(long), join(long, int), sleep(long), sleep(long, int)会让它进入阻塞状态
 * 若线程在阻塞状态时，调用了它的interrupt()方法，那么它的“中断状态”会被清除并且会收到一个InterruptedException异常。
 * 线程通过wait()进入阻塞状态，此时通过interrupt()中断该线程；调用interrupt()会立即将线程的中断标记设为“true”，
 * 但是由于线程处于阻塞状态，所以该“中断标记”会立即被清除为“false”，同时，会产生一个InterruptedException的异常。
 *
 * 线程被阻塞在一个Selector选择器中，那么通过interrupt()中断它时；线程的中断标记会被设置为true，并且它会立即从选择操作中返回。
 * 如果不属于前面所说的情况，那么通过interrupt()中断线程时，它的中断标记会被设置为“true”。
 *
 * 中断一个“已终止的线程”不会产生任何操作。
 *
 *
 * 如何正常的停止一个线程
 */
public class InterruptDemo{

    static class ThreadA extends Thread{

        public ThreadA(String t1) {
            super(t1);
        }

        public void run(){
            try {
                int i=0;
                while (!isInterrupted()) {
                    Thread.sleep(100); // 休眠100ms
                    i++;
                    System.out.println(Thread.currentThread().getName()+" ("+this.getState()+") loop " + i);
                }
                } catch (InterruptedException e) {//会产生一个InterruptedException的异常。
                    System.out.println(Thread.currentThread().getName() +" ("+this.getState()+") catch InterruptedException.");
                }
        }
    }


    static class ThreadB extends Thread{

        public ThreadB(String t1) {
            super(t1);
        }

        public void run(){
            int i=0;
            while (!isInterrupted()) {
                try {
                    Thread.sleep(100); // 休眠100ms
                    i++;
                    System.out.println(Thread.currentThread().getName()+" ("+this.getState()+") loop " + i);
                } catch (InterruptedException e) {
                    System.out.println(Thread.currentThread().getName() +" ("+this.getState()+") catch InterruptedException.");
                }
            }
        }
    }

//如何正常的停止一个线程
    static class ThreadC extends Thread{

        private volatile boolean flag = true;

        public void stopTask(){
            flag = false;
        }

        public ThreadC(String t1) {
            super(t1);
        }


        public void run(){
            try {
                int i=0;
                while (flag) {
                    Thread.sleep(100); // 休眠100ms
                    i++;
                    System.out.println(Thread.currentThread().getName()+" ("+this.getState()+") loop " + i);
                }
            } catch (InterruptedException e) {//会产生一个InterruptedException的异常。
                System.out.println(Thread.currentThread().getName() +" ("+this.getState()+") catch InterruptedException.");
            }
        }
    }



    static void demo1()throws Exception{
        ThreadA t1 = new ThreadA("t1");
        System.out.println(t1.getName() +" ("+t1.getState()+") is new.");
        t1.start();
        System.out.println(t1.getName() +" ("+t1.getState()+") is started.");
        Thread.sleep(300);
        t1.interrupt();
        System.out.println(t1.getName() +" ("+t1.getState()+") is interrupted.");
        Thread.sleep(300);
        System.out.println(t1.getName() +" ("+t1.getState()+") is interrupted now.");
    }

    static void demo2()throws Exception{
        ThreadB t1 = new ThreadB("t2");
        System.out.println(t1.getName() +" ("+t1.getState()+") is new.");
        t1.start();
        System.out.println(t1.getName() +" ("+t1.getState()+") is started.");
        Thread.sleep(300);
        t1.interrupt();
        System.out.println(t1.getName() +" ("+t1.getState()+") is interrupted.");
        Thread.sleep(300);
        System.out.println(t1.getName() +" ("+t1.getState()+") is interrupted now.");
    }

    static void demo3() throws Exception{
        ThreadC t1 = new ThreadC("t3");
        System.out.println(t1.getName() +" ("+t1.getState()+") is new.");
        t1.start();
        System.out.println(t1.getName() +" ("+t1.getState()+") is started.");
        Thread.sleep(300);
        t1.stopTask();
        System.out.println(t1.getName() +" ("+t1.getState()+") is interrupted.");
        Thread.sleep(300);
        System.out.println(t1.getName() +" ("+t1.getState()+") is interrupted now.");
    }

    public static void main(String[]args)throws Exception{
        demo1();
        demo3();

    }


}
