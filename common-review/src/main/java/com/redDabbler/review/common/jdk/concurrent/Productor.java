package com.redDabbler.review.common.jdk.concurrent;

import lombok.extern.slf4j.Slf4j;


@Slf4j
public class Productor implements Runnable{

    private Product product;

    private int size = 1000;

    public Productor(Product product,int size){
        this.product = product;
        this.size = size;
    }

    public Productor(Product product){
        this.product = product;
    }

    public void run(){
        while(true){
            try{
                if(product.getNumber()==size){
                    product.wait();
                    log.info("wait on thread:{}",Thread.currentThread().getName());
                }
            }catch (InterruptedException e){
                log.error("",e);
            }
            product.increase();
        }
    }

}
