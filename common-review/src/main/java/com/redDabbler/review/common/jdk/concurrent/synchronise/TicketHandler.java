package com.redDabbler.review.common.jdk.concurrent.synchronise;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class TicketHandler {

    int num = 200;

    public int getNum(){
        log.info("{} num:{}",Thread.currentThread().getName(),num);
        return num;
    }

    public synchronized void sell(){
        num = num -1;
        log.info("{} sell",Thread.currentThread().getName());
    }

    public synchronized void reback(){
        num = num + 1;
        log.info("{} reback",Thread.currentThread().getName());
    }

    public static void main(String[]args){

    }
}
