package com.redDabbler.review.common.jdk.concurrent;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Consumer implements Runnable{
    private Product product;

    public Consumer(Product product){
        this.product = product;
    }

    public void run() {

        while(true){
            try{
                if(product.getNumber()==0){
                    product.wait();
                    log.info("wait on thread",Thread.currentThread().getName());
                }
            }catch (InterruptedException e){
                log.error("InterruptedException",e);
            }

            product.decrease();
        }
    }
}
