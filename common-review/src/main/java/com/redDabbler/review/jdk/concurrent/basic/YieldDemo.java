package com.redDabbler.review.jdk.concurrent.basic;


/**
 * yield的作用是让步，他能让线程从运行状态进入到就绪状态，从而让其他具有相同优先级的等待线程有机会获得执行权
 * 但是，并不能保证具有相同优先级的其他线程一定能获得优先权,也有可能当前线程又进入到运行状态，继续执行

 *
 * 向调度程序提示当前线程愿意让步当前使用的处理器。 调度程序可以随意忽略它暗示。
 * 很少适合使用此方法。 可能有用用于调试或测试目的，可能有助于重现由于竞争而引起的bug。 在设计并发控制构造时也可能有用
 * 例如 {@link java.util.concurrent.locks}包。
 * 让掉当前线程 CPU 的时间片，使正在运行中的线程重新变成就绪状态，并重新竞争 CPU 的调度权。它可能会获取到，也有可能被其他线程获取到。
 *
 *
 * wait()是会线程释放它所持有对象的同步锁，而yield()方法不会释放锁。sleep 是让当前线程休眠阻塞，不释放
 */
public class YieldDemo {
    private static Object obj = new Object();
    static class ThreadA extends Thread{

        public  void run(){
            System.out.printf("%s [%d]---------\n", this.getName(), this.getPriority());
            // yield 不会释放锁
            synchronized (obj) {
                for (int i = 0; i < 100; i++) {
                    System.out.printf("%s [%d]:%d\n", this.getName(), this.getPriority(), i);

                //     i整除4时，调用yield
                    if (i%4 == 0)  Thread.yield();
                }
            }



        }
    }

    static class RunableA implements Runnable{
        public void run(){
            for (int i = 0; i < 100; i++) {
                System.out.printf("%s [%d]:%d\n", Thread.currentThread().getName(), Thread.currentThread().getPriority(), i);
                //     i整除4时，调用yield
                if (i%4 == 0)  Thread.yield();
            }
        }
    }

    public static void main(String[]args){
//        ThreadA threadA = new ThreadA();
//        ThreadA threadA1 = new ThreadA();
//        threadA.start();
//        threadA1.start();
       demo();
    }

    public static void demo(){

        RunableA runableA = new RunableA();
        Thread thread = new Thread(runableA,"t1");
        Thread thread1 = new Thread(runableA,"t2");

        thread.start();
        thread1.start();

    }
}
