package com.redDabbler.review.common.jdk.concurrent;

public class HandlerProduct {

    public static void main(String []args){
        Product product = new Product();
        product.setNumber(1000);
        Productor productor = new Productor(product);
        Consumer consumer = new Consumer(product);
        for(int i =0;i<5;i++){
            Thread produce = new Thread(productor);
            produce.start();
        }

//        Thread consume = new Thread(consumer);
//
//        consume.start();



    }



}
