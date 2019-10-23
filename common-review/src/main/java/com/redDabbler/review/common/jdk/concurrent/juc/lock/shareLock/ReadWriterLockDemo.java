package com.redDabbler.review.common.jdk.concurrent.juc.lock.shareLock;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 *
 * Thread-0启动并获取到“读取锁”，在它还没运行完毕的时候，Thread-2也启动了并且也成功获取到“读取锁”。
 * 因此，“读取锁”支持被多个线程同时获取。
 */
public class ReadWriterLockDemo {
    public static  void main(String[]args){
        // 创建账户
       MyCount myCount = new MyCount("4238920615242830", 10000);

        // 创建用户，并指定账户
        User user = new User("Tommy", myCount);
        // 分别启动3个“读取账户金钱”的线程 和 3个“设置账户金钱”的线程
        for (int i=0; i<3; i++) {
            user.getCash();
            user.setCash((i+1)*1000);
        }
    }

    static class User{
        private String name;
        private MyCount myCount;
        private ReadWriteLock readWriteLock;

        public User(String name, MyCount myCount) {
            this.name = name;
            this.myCount = myCount;
            this.readWriteLock = new ReentrantReadWriteLock();
        }

        public void getCash(){
            new Thread(){
                public void run(){
                    readWriteLock.readLock().lock();
                    try{
                        System.out.println(Thread.currentThread().getName() +" getCash start");
                        myCount.getCash();
                        Thread.sleep(1);
                        System.out.println(Thread.currentThread().getName() +" getCash end");
                    }catch (InterruptedException e){

                    }finally {
                        readWriteLock.readLock().unlock();
                    }
                }
            }.start();
        }

        public void setCash(final int cash){
            new Thread(){
                public void run(){
                    readWriteLock.writeLock().lock();
                    try{
                        System.out.println(Thread.currentThread().getName() +" setCash start");
                        myCount.setCash(cash);
                        Thread.sleep(1);
                        System.out.println(Thread.currentThread().getName() +" setCash end");
                    }catch (InterruptedException e){

                    }finally {
                        readWriteLock.writeLock().unlock();
                    }
                }
            }.start();

        }

    }

    static class MyCount{
        String id;//账户
        int cash;//余额

        public MyCount(String id, int cash) {
            this.id = id;
            this.cash = cash;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public int getCash() {
            System.out.println(Thread.currentThread().getName() +" getCash cash="+ cash);
            return cash;
        }

        public void setCash(int cash) {
            System.out.println(Thread.currentThread().getName() +" setCash cash="+ cash);
            this.cash = cash;
        }
    }
}
