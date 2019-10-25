package com.redDabbler.review.jdk.concurrent.juc.lock.Productor_Consumer;

public class Productor  {

    private Product product;

    public Productor(Product product){
        this.product = product;
    }

    public void produce(final int val){
        new Thread(){
            public void run(){
                product.produce(val);
            }
        }.start();
    }

}
