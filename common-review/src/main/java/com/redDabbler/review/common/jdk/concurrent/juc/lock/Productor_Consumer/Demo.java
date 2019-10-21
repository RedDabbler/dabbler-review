package com.redDabbler.review.common.jdk.concurrent.juc.lock.Productor_Consumer;

public class Demo {

    public static void main(String[]rags){
        Product product = new Product(100);
        Consumer consumer = new Consumer(product);
        Productor productor = new Productor(product);
        consumer.consumer(17);
        consumer.consumer(20);
        productor.produce(121);
    //    productor.produce(120);
        consumer.consumer(20);
        consumer.consumer(20);

    }
}
