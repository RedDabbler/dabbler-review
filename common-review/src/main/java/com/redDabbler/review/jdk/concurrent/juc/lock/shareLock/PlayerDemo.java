package com.redDabbler.review.jdk.concurrent.juc.lock.shareLock;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.locks.LockSupport;

/**
 * 第一我们必须确保这5个选手都准备就绪了，才能宣布比赛开始
 * 第二只有当5个选手都完成比赛了才能宣布比赛结束
 */
public class PlayerDemo {

    private static Thread mainThread;

    public static void main(String[]args)throws Exception{

        CyclicBarrier begin = new CyclicBarrier(10);
        CountDownLatch end = new CountDownLatch(10);

        for (int i=0;i<10;i++){
            Player player = new Player("t"+i,begin,end);
            Thread thread = new Thread(player);
            thread.start();
        }

        mainThread = Thread.currentThread();
        LockSupport.park(mainThread);
        System.out.println("Race begins!");
        end.await();
        System.out.println("race complete");


    }

    static class Player implements Runnable{
        CyclicBarrier begin;
        CountDownLatch end;
        String name;

        public Player(String name,CyclicBarrier begin,CountDownLatch end){
            this.name = name;
            this.begin = begin;
            this.end = end;
        }


        public void run(){
            try {
                System.out.printf("%s ready \n",name);
                begin.await();
                LockSupport.unpark(mainThread);
                System.out.printf("%s run \n",name);
                Thread.sleep((long)(Math.random()*100)*100);
                System.out.printf("%s arrive end \n",name);
                end.countDown();
            }catch (Exception e){

            }



        }
    }
}
