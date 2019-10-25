package com.redDabbler.review.jdk.concurrent.basic.wait_notify.Productor_Consumer;

public class Productor {

    private Product product;

    public Productor(Product product){
        this.product = product;
    }

    public void produce(final int val){
        new Thread(){
            public void run(){
                System.out.println("producing.....");
                product.produce(val);
            }
        }.start();
    }
}
