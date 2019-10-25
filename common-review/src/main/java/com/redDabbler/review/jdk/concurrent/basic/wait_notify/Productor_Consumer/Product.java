package com.redDabbler.review.jdk.concurrent.basic.wait_notify.Productor_Consumer;


/**
 * (01) 生产者仅仅在仓储未满时候生产，仓满则停止生产。
 * (02) 消费者仅仅在仓储有产品时候才能消费，仓空则等待。
 * (03) 当消费者发现仓储没产品可消费时候会通知生产者生产。
 * (04) 生产者在生产出可消费产品时候，应该通知等待的消费者去消费。
 */

public   class Product{
    private int capacity;
    private int size;//实际的数据

    public Product(int capacity){
        this.capacity = capacity;
    }

    public synchronized void  produce(int val){
        try{
            int left = val;
            while(left>0){

                left = left - 1;
                size = size + 1 ;
                //FIXME 这里使用if的话，就会存在wait条件变化造成程序错误的问题
                while(size>=capacity){
                    System.out.println("生产者" + Thread.currentThread().getName() + "  list以达到最大容量，进行wait");
                    wait();
                    System.out.println("生产者" + Thread.currentThread().getName() + " 退出wait");
                }
                System.out.printf("%s produce(%3d) --> left=%3d,  size=%3d\n", Thread.currentThread().getName(), val, left, size);
                this.notifyAll();
            }



        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }

    public synchronized void consumer(int val){
        try{

            int left = val;
            while(left>0){
                while (size==0){
                    this.wait();
                }
                left = left - 1;
                size = size - 1;
                System.out.printf("%s consume(%3d) <-- left=%3d,  size=%3d\n", Thread.currentThread().getName(), val, left, size);
                this.notifyAll();
            }



        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }


}
