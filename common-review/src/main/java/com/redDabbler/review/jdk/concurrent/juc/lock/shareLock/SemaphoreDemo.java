package com.redDabbler.review.jdk.concurrent.juc.lock.shareLock;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * Semaphore是一个计数信号量，它的本质是一个"共享锁"。
 * 信号量维护了一个信号量许可集。线程可以通过调用acquire()来获取信号量的许可；
 * 当信号量中有可用的许可时，线程能获取该许可；否则线程必须等待，直到有可用的许可为止。
 * 线程可以通过release()来释放一个所持有的信号量许可。
 * 根据共享锁的获取原则，Semaphore分为"公平信号量"和"非公平信号量"。
 *
 * Semaphore 只对可用许可的号码进行计数，并采取相应的行动。拿到信号量的线程可以进入代码，
 * 否则就等待。通过acquire()和release()获取和释放访问许可。
 *
 * 注意，调用 acquire() 时无法保持同步锁，因为这会阻止将项返回到池中。
 * 信号量封装所需的同步，以限制对池的访问，这同维持该池本身一致性所需的同步是分开的
 * 我拿到了一个，别人就无法拿到了，我释放了别人才能拿到，
 * 我拿到了之后去操作公共数据的时候，针对这个数据操作的同步Semaphore就不管了，这就需要我们自己去同步了
 */
public class SemaphoreDemo {

    private static int SEM_MAX  = 10;

    public static void main(String[]args){
        Semaphore semaphore = new Semaphore(SEM_MAX);
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        executorService.execute(new InnerThread(5,semaphore));
        executorService.execute(new InnerThread(4,semaphore));
        executorService.execute(new InnerThread(7,semaphore));
        executorService.shutdown();
    }

    static class InnerThread extends Thread{
        private volatile  Semaphore semaphore ;
        private int count;


        InnerThread(int count,Semaphore semaphore){
            this.count = count;
            this.semaphore = semaphore;
        }

        public void run(){
            try{
               semaphore.acquire(count);
               Thread.sleep(3000);
                System.out.println(Thread.currentThread().getName() + " acquire count="+count);
            } catch (InterruptedException e){
                e.printStackTrace();
            }finally {
                semaphore.release(count);
                System.out.println(Thread.currentThread().getName() + " release " + count + "");
            }

        }
    }
}
