package com.redDabbler.review.common.jdk.concurrent.basic.wait_notify.Productor_Consumer;

public class Demo{
    public static  void main(String[]args){
        Product product = new Product(100);
        Consumer consumer = new Consumer(product);
        Productor productor = new Productor(product);
        consumer.consume(20);
        consumer.consume(20);
        productor.produce(120);
        productor.produce(120);
        consumer.consume(20);
        consumer.consume(20);
    }
}
