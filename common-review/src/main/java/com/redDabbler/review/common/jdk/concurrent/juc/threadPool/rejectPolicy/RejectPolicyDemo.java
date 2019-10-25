package com.redDabbler.review.common.jdk.concurrent.juc.threadPool.rejectPolicy;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class RejectPolicyDemo {

    public static void discardPolicy(){
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(2,2,
                5, TimeUnit.SECONDS,new ArrayBlockingQueue<Runnable>(2));

        threadPoolExecutor.setRejectedExecutionHandler(new ThreadPoolExecutor.DiscardPolicy());

        for (int i =0;i<10;i++){
            //当有任务添加到线程池被拒绝时，线程池会丢弃阻塞队列中末尾的任务，然后将被拒绝的任务添加到末尾。
            Runnable runnable = new MyRunnable("t"+i);
            threadPoolExecutor.execute(runnable);
        }
        threadPoolExecutor.shutdown();
    }

    public static  void discardOldesrPolicy(){
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(2,2,
                5, TimeUnit.SECONDS,new ArrayBlockingQueue<Runnable>(2));

        threadPoolExecutor.setRejectedExecutionHandler(new ThreadPoolExecutor.DiscardOldestPolicy());

        for (int i =0;i<10;i++){
            Runnable runnable = new MyRunnable("t"+i);
            threadPoolExecutor.execute(runnable);
        }
        threadPoolExecutor.shutdown();
    }

    public static  void abortPolicy(){
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(1,1,
                5, TimeUnit.SECONDS,new ArrayBlockingQueue<Runnable>(1));

        threadPoolExecutor.setRejectedExecutionHandler(new ThreadPoolExecutor.AbortPolicy());

        try{
            for (int i =0;i<10;i++){
                //当有任务添加到线程池被拒绝时，线程池会丢弃阻塞队列中末尾的任务，然后将被拒绝的任务添加到末尾。
                Runnable runnable = new MyRunnable("t"+i);
                threadPoolExecutor.execute(runnable);
            }
        }catch (RejectedExecutionException e){
            e.printStackTrace();
            //需要捕获异常，否则线程池不会关闭
            threadPoolExecutor.shutdown();

        }

        //需要捕获异常，否则线程池不会关闭
        threadPoolExecutor.shutdown();

    }

    public static void CallerRunsPolicy(){
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(1,1,
                5, TimeUnit.SECONDS,new ArrayBlockingQueue<Runnable>(1));

        threadPoolExecutor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());

        for (int i =0;i<10;i++){
            //当有任务添加到线程池被拒绝时，线程池会丢弃阻塞队列中末尾的任务，然后将被拒绝的任务添加到末尾。
            Runnable runnable = new MyRunnable("t"+i);
            threadPoolExecutor.execute(runnable);
        }
        threadPoolExecutor.shutdown();
    }

    public static void main(String[]args){

    //    abortPolicy();
        CallerRunsPolicy();
    }
}
