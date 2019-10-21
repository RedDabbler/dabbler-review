package com.redDabbler.review.common.jdk.concurrent.juc.lock.Productor_Consumer;

public class Consumer {

    private Product product;

    public Consumer(Product product){
        this.product = product;
    }

    public void consumer(final int val){
        new Thread(){
            public void run(){
                product.consumer(val);
            }
        }.start();
    }
}
