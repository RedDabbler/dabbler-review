package com.redDabbler.review.common.jdk.concurrent;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

@Getter
@Setter
@Slf4j
public class Product {

    private int number;


    public void decrease(){
        number = number - 1;
        log.info("buy product ,then number is {}",number);
    }

    public void increase(){
        number = number + 1;
        log.info("produce product,number is{}",number);
    }





}
