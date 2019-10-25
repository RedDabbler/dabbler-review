package com.redDabbler.review.jdk.concurrent.juc.lock.reentrantLock;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadInfo;
import java.lang.management.ThreadMXBean;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 可中断的锁
 */
public class LockInterrupt extends Thread {
    private static ReentrantLock lock1 = new ReentrantLock();
    private static ReentrantLock lock2 = new ReentrantLock();

    private int index;

    public LockInterrupt(String name,int index){
        super(name);
        this.index = index;
    }

    public void run(){
        try {
            if (index == 1){
                lock1.lockInterruptibly();
                Thread.sleep(500);
                lock2.lockInterruptibly();
            }else {
                lock2.lockInterruptibly();
                Thread.sleep(500);
                lock1.lockInterruptibly();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally{
            if(lock1.isHeldByCurrentThread()){
                lock1.unlock();
            }
            if (lock2.isHeldByCurrentThread()){
                lock2.unlock();
            }
            System.out.println(Thread.currentThread().getName()+"线程退出");
        }
    }

    public static void main(String[]args){
        LockInterrupt lockInterrupt = new LockInterrupt("thread1",1);
        LockInterrupt lockInterrupt1 = new LockInterrupt("thread2",2);

        lockInterrupt.start();
        lockInterrupt1.start();
        DeadLockCheck.check();
    }

    static class DeadLockCheck{
        private static ThreadMXBean mxBean = ManagementFactory.getThreadMXBean();
        public static void check(){
            Thread tt = new Thread(){
                public void run(){
                    while(true){
                       long[]deadlockedThreadIds =  mxBean.findDeadlockedThreads();
                       if (deadlockedThreadIds!=null){
                          ThreadInfo[] threadInfos =  mxBean.getThreadInfo(deadlockedThreadIds);
                          for(Thread t:Thread.getAllStackTraces().keySet()){
                              for(ThreadInfo threadInfo:threadInfos){
                                  if(t.getId() == threadInfo.getThreadId()){
                                      System.out.println(threadInfo.getThreadName());
                                      t.interrupt();
                                  }

                              }
                          }

                       }
                    }
                }
            };
            tt.setDaemon(true);
            tt.start();
        }
    }
}
