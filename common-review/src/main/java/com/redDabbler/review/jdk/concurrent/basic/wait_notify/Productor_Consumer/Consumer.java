package com.redDabbler.review.jdk.concurrent.basic.wait_notify.Productor_Consumer;

public class Consumer {
    private Product product;

    public Consumer(Product product){
        this.product = product;
    }

    public void consume(final int val){
        new Thread(){
            public void run(){
                System.out.println("consuming.....");
                product.consumer(val);
            }
        }.start();
    }
}
